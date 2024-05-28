package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.FolderReqeustDto;
import com.sparta.myselectshop.security.UserDetailsImpl;
import com.sparta.myselectshop.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/folders")
    public void addFolder(@RequestBody FolderReqeustDto folderReqeustDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<String> folderNames = folderReqeustDto.getFolderNames();
        folderService.addFolder(folderNames, userDetails.getUser());
    }

}
