package com.common.jmark.controller;

import com.common.jmark.dto.resume.*;
import com.common.jmark.service.resume.AwardService;
import com.common.jmark.service.resume.CareerDetailService;
import com.common.jmark.service.resume.LicenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
@Api(tags={"이력서 API"})
public class ResumeController {
    private final AwardService awardService;
    private final CareerDetailService careerDetailService;
    private final LicenseService licenseService;

    @PostMapping("/{userId}/career")
    @ApiOperation(value = "경력사항 추가", notes = "경력사항을 추가합니다.")
    public ResponseEntity<?> createCareer (
            @PathVariable Long userId,
            @Valid @RequestBody CareerDetailCreateRequest request
            ) {
        Long careerDetailId = careerDetailService.create(userId, request);
        Map<String, Long> response = new HashMap<>();
        response.put("careerDetailId", careerDetailId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/career")
    @ApiOperation(value = "경력사항 조회", notes = "경력사항을 조회합니다.")
    public ResponseEntity<?> readCareerList (
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(careerDetailService.readList(userId));
    }

    @GetMapping("/career/{careerDetailId}")
    @ApiOperation(value = "경력사항 상세 조회", notes = "경력사항을 상세 조회합니다.")
    public ResponseEntity<?> readCareer (
            @PathVariable Long careerDetailId
    ) {
        return ResponseEntity.ok(careerDetailService.read(careerDetailId));
    }

    @PutMapping("/career/{careerDetailId}")
    @ApiOperation(value = "경력사항 수정", notes = "경력사항을 수정합니다.")
    public ResponseEntity<?> updateCareer (
            @PathVariable Long careerDetailId,
            @Valid @RequestBody CareerDetailUpdateRequest request
            ) {
        careerDetailService.update(careerDetailId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/career/{careerDetailId}")
    @ApiOperation(value = "경력사항 삭제", notes = "경력사항을 삭제합니다.")
    public ResponseEntity<Map<String, Long>> deleteCareer (
            @PathVariable Long careerDetailId
    ) {
        careerDetailService.delete(careerDetailId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{userId}/awards")
    @ApiOperation(value = "수상경력 추가", notes = "수상경력을 추가합니다.")
    public ResponseEntity<?> createAward(
            @PathVariable Long userId,
            @Valid @RequestBody AwardCreateRequest request
    ) {
        Long awardId = awardService.create(userId, request);
        Map<String, Long> response = new HashMap<>();
        response.put("awardId", awardId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/awards")
    @ApiOperation(value = "수상경력 조회", notes = "수상경력을 조회합니다.")
    public ResponseEntity<?> readAwardList (
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(awardService.readList(userId));
    }

    @GetMapping("/awards/{awardId}")
    @ApiOperation(value = "수상경력 상세 조회", notes = "수상경력을 상세 조회합니다.")
    public ResponseEntity<?> readAward (
            @PathVariable Long awardId
    ) {
        return ResponseEntity.ok(awardService.read(awardId));
    }

    @PutMapping("/awards/{awardId}")
    @ApiOperation(value = "수상경력 수정", notes = "수상경력을 수정합니다.")
    public ResponseEntity<?> updateAward (
            @PathVariable Long awardId,
            @Valid @RequestBody AwardUpdateRequest request
    ) {
        awardService.update(awardId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/awards/{awardId}")
    @ApiOperation(value = "수상경력 삭제", notes = "수상경력을 삭제합니다.")
    public ResponseEntity<Map<String, Long>> deleteAward (
            @PathVariable Long awardId
    ) {
        awardService.delete(awardId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{userId}/license")
    @ApiOperation(value = "자격증 추가", notes = "자격증을 추가합니다.")
    public ResponseEntity<?> createLicense (
            @PathVariable Long userId,
            @Valid @RequestBody LicenseCreateRequest request
    ) {
        Long licenseId = licenseService.create(userId, request);
        Map<String, Long> response = new HashMap<>();
        response.put("licenseId", licenseId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/license")
    @ApiOperation(value = "자격증 조회", notes = "자격증을 조회합니다.")
    public ResponseEntity<?> readLicenseList (
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(licenseService.readList(userId));
    }

    @GetMapping("/license/{licenseId}")
    @ApiOperation(value = "자격증 상세 조회", notes = "자격증을 상세 조회합니다.")
    public ResponseEntity<?> readLicense (
            @PathVariable Long licenseId
    ) {
        return ResponseEntity.ok(licenseService.read(licenseId));
    }

    @PutMapping("/license/{licenseId}")
    @ApiOperation(value = "자격증 수정", notes = "자격증을 수정합니다.")
    public ResponseEntity<?> updateLicense (
            @PathVariable Long licenseId,
            @Valid @RequestBody LicenseUpdateRequest request
    ) {
        licenseService.update(licenseId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/license/{licenseId}")
    @ApiOperation(value = "자격증 삭제", notes = "자격증을 삭제합니다.")
    public ResponseEntity<Map<String, Long>> deleteLicense (
            @PathVariable Long licenseId
    ) {
        licenseService.delete(licenseId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
