import { createRouter, createWebHistory } from 'vue-router'
import ResumeStepOne from '../components/resume/ResumeStepOne.vue'
import ResumeStepTwo from '../components/resume/ResumeStepTwo.vue'
import ResumeStepThree from '../components/resume/ResumeStepThree.vue'
import ResumeStepFour from '../components/resume/ResumeStepFour.vue'
import ResumeStepFive from '../components/resume/ResumeStepFive.vue'
import LoginView from '../views/user/LoginView.vue'
import SignupView from '../views/user/SignupView.vue'
import SignupCompleteView from '../views/user/SignupCompleteView.vue'
import FindPasswordView from '../views/user/FindPasswordView.vue'
import FindUsernameView from '../views/user/FindUsernameView.vue'

import CompanyHomeView from "@/views/home/CompanyHomeView.vue";
import HomeView from "../views/home/HomeView.vue";
// import CompanyInterviewView from "@/views/CompanyInterviewView.vue";
import CompanyJobOpeningView from "@/views/CompanyJobOpeningView.vue";

// import CompanyMyPageView from "@/views/CompanyMyPageView.vue";

import CompanyJobOpeningDetail from "@/components/Company/JobOpening/JobOpeningDetail.vue";


import CompanyJobOpeningList from "@/components/Company/JobOpening/JobOpeningList.vue";
import CompanyJobOpeningRegist from "@/components/Company/JobOpening/JobOpeningRegist.vue";
import CompanyJobOpeningUpdate from "@/components/Company/JobOpening/JobOpeningUpdate.vue";
// import CompanyInterview from "@/components/Company/Interview/CompanyInterview.vue";
// import CompanyMyPage from "@/components/Company/MyPage/CompanyMyPage.vue";


//boards
import BoardMain from "@/views/board/BoardMain.vue"
import BoardDetail from "@/views/board/BoardDetail.vue"
import BoardCreate from "@/views/board/BoardCreate.vue"
import BoardUpdate from "@/views/board/BoardUpdate.vue"

//video
import VideoMain from "@/views/video/VideoMain.vue"

//practice
import QuestionList from "@/views/practice/QuestionList"
import QuestionAnswer from "@/views/practice/QuestionAnswer"
import VideoPractice from "@/views/practice/VideoPractice"
import VideoPracticeList from "@/views/practice/VideoPracticeList"



const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },

  //user
  {
    path: "/login",
    name: "Login",
    component: LoginView,
  },
  {
    path: "/signup",
    name: "Signup",
    component: SignupView,
  },
  {
    path: "/signup/complete",
    name: "SignupComplete",
    component: SignupCompleteView,
  },
  {
    path: "/find/password",
    name: "FindPassword",
    component: FindPasswordView,
  },
  {
    path: "/find/username",
    name: "FindUsername",
    component: FindUsernameView,
  },

  // resume
  {
    path: "/resume/edit/1",
    component: ResumeStepOne,
    name: "ResumeStepOne",
  },
  {
    path: '/resume/edit/2',
    component: ResumeStepTwo,
    name: 'ResumeStepTwo' 
  },
  {
    path: '/resume/edit/3',
    component: ResumeStepThree,
    name: 'ResumeStepThree' 
  },
  {
    path: '/resume/edit/4',
    component: ResumeStepFour,
    name: 'ResumeStepFour' 
  },
  {
    path: '/resume/edit/5',
    component: ResumeStepFive,
    name: 'ResumeStepFive' 
  },

  // condition
  {
    path: "/condition",
    name: "Condition",
    component: () => import("@/views/condition/ConditionView.vue"),
    children: [
      {
        path: "create",
        name: "ConditionCreate",
        component: () => import("@/views/condition/ConditionCreateView.vue")
      },
      {
        path: "result",
        name: "ConditionResult",
        component: () => import("@/views/condition/ConditionResultView.vue")
      }
    ]
  },

  // jobopening
  {
    path: "/jobopening",
    name: "Jobopening",
    component: () => import("../views/jobopening/JobopeningView.vue"),
  },
  {
    path: "/jobopening/:jobopeningId",
    name: "JobopeningDetail",
    component: () => import("../views/jobopening/JobopeningDetailView.vue"),
  },
  {
    path: "/company",
    name: "company",
    component: CompanyHomeView,
  },
  {
    path: "/company/jobopening",
    name: "companyjobopening",
    component: CompanyJobOpeningView,
    redirect: "/company/jobopening/list",
    children: [
      {
        path: "list",
        name: "companyjobopeninglist",
        component: CompanyJobOpeningList,
      },
      {
        path: "regist",
        name: "companyjobopeningregist",
        component: CompanyJobOpeningRegist,
      },
      {
        path: "detail/:no",
        name: "companyjobopeningdetail",
        component: CompanyJobOpeningDetail,
      },
      {
        path: "update/:no",
        name: "companyjobopeningupdate",
        component: CompanyJobOpeningUpdate,
      },
    ],
  },
  {
    path: "/boards/:category_id",
    component: BoardMain,
    name: "boardMain",
  },
  {
    path: "/boards/:category_id/:board_id",
    component: BoardDetail,
    name: "boardDetail",
  },
  {
    path: "/boards/:category_id/create",
    component: BoardCreate,
    name: "boardCreate",
  },
  {
    path: "/boards/:category_id/:board_id/update",
    component: BoardUpdate,
    name: "boardUpdate",
  },

  //video
  {
    path: "/video",
    component: VideoMain,
    name: "VideoMain",
  },

  //video practice
  {
    path: "/practice/questions",
    name: "QuestionList",
    component: QuestionList,
  },
  {
    path: "/practice/question/:question_id/answer",
    component: QuestionAnswer,
    name: "QuestionAnswer",
  },
  {
    path: "/practice/videopractices",
    component: VideoPracticeList,
    name: "VideoPracticeList",
  },
  {
    path: "/practice/videopractice",
    component: VideoPractice,
    name: "VideoPractice",
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
