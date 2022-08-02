import router from '@/router'
import axios from 'axios'
import jwt_decode from 'jwt-decode'

import { login, findById } from '@/api/user.js'

export const user = {
    state: {
      // token: localStorage.getItem('token') || '',
      currentUser: {},
      profile: {},
      authError: null,
      // 코드추가
      isLogin: false,
      userInfo: null,
    },

    getters: {
      isLogginedIn: state => !!state.token,
      currentUser: state => state.currentUser,
      profile: state => state.profile,
      authError: state => state.authError,
      // Authorization: `Token ${state.token}`
      authHeader: state => ({ Authorization: ` ${state.token}` })
    },

    mutations: {
      SET_TOKEN: (state, token) => state.token = token,
      SET_CURRENT_USER: (state, user) => state.currentUser = user,
      SET_PROFILE: (state, profile) => state.profile = profile,
      SET_AUTH_ERROR: (state, error) => state.authError = error,
      // 추가
      SET_IS_LOGIN: (state, isLogin) => state.isLogin = isLogin,
      SET_USER_INFO: (state, userInfo) => {
        state.isLogin = true;
        state.userInfo = userInfo;
      }
    },

    actions: {
      saveToken({ commit }, token){
        commit('SET_TOKEN', token)
        localStorage.setItem('token', token)
      },

      removeToken({ commit }) {
        commit('SET_TOKEN', '')
        localStorage.setItem('token', '')
      },

      // error 커밋 추가
      // login({ dispatch }, credentials){
      //   axios({
      //     // url 수정
      //     url: '',
      //     method: 'post',
      //     data: credentials
      //   })
      //   .then(res => {
      //     const token = res.data.key
      //     dispatch('saveToken', token)
      //     dispatch('fetchCurrentUser')
      //     // router 수정
      //     router.push({ name: 'home'})
      //   })
      //     // error 부분 추가
      // },

      // 추가
      async userConfirm({ commit }, credentials){
        await login(credentials, (response)=> {
          if (response.data.message === "success" ){
            let token = response.data["access-token"]
            commit("SET_IS_LOGIN", true)
            // error 부분 추가
            sessionStorage.setItem("access-token", token);
          } else {
            commit("SET_IS_LOGIN", false);
          }
        })
      },

      getUserInfo({ commit }, token){
        let decode_token = jwt_decode(token);
        findById(decode_token.id, (response) => {
          if (response.data.message === "success"){
            commit("SET_USER_INFO", response.data.userInfo)
          }
        })
      },

      // error 커밋 추가
      signup(credentials){
        axios({
          // url 수정
          url: '',
          method: 'post',
          data: credentials
        })
        // .then(res) < 수정
        .then(() => {
          // 더 로직이 있을지도..
          router.push({ name: 'login' })
        })
        // error 부분 추가
      },

      fetchMypage({ commit, getters }, user_id){
        axios({
          // url 수정
          url: user_id,
          method: 'get',
          headers: getters.authHeader,
        })
        .then(res => {
          commit('SET_PROFILE', res.data)
        })
      },

      fetchCurrentUser({ commit, getters, dispatch }){
        if (getters.isLogginedIn) {
          axios({
            // url 수정
            url : '',
            method: 'get',
            headers: getters.authHeader,
          })
          .then(res => {
            commit('SET_CURRENT_USER', res.data)
            dispatch('fetchMypage', res.data.user_id)
          })
          .catch(err => {
            if (err.response.status === 401){
              dispatch('removeToken')
              router.push({ name: 'Login'})
            }
          })
        }
      }
    },

    modules: {
    }
  }
  