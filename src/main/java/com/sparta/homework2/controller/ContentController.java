package com.sparta.homework2.controller;

import com.sparta.homework2.dto.ContentRequestDto;
import com.sparta.homework2.dto.NewPasswordDto;
import com.sparta.homework2.dto.ReturnDto;
import com.sparta.homework2.entity.Content;
import com.sparta.homework2.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/api/contents")
    public Content createContent(@RequestBody ContentRequestDto requestDto) throws SQLException {
        Content content = contentService.createContent(requestDto);
        return content;
    }

    @PutMapping("/api/contents/{id}")
    public Content updateProduct(@PathVariable Long id, @RequestBody ContentRequestDto requestDto) throws SQLException {
        Content content = contentService.updateContent(id, requestDto);

        // 응답 보내기 (업데이트된 상품 id)
        return content;
    }

    @PostMapping("/api/contents/{id}")
    public boolean checkPw(@PathVariable Long id, @RequestBody NewPasswordDto requestDto) throws SQLException{
        boolean bool = contentService.checkPw(id, requestDto);
        return bool;
    }

    @GetMapping("/api/contents")
    public List<Content> getContents() throws SQLException {
        List<Content> contents = contentService.getContents();
        return contents;
    }

    @GetMapping("/api/contents/{id}")
    public ReturnDto getContent(@PathVariable Long id) throws SQLException {
        ReturnDto returnDto = contentService.getContent(id);
        return returnDto;
    }

    @DeleteMapping("/api/contents/{id}")
    public Long delContent(@PathVariable Long id) throws SQLException{
        Long bool = contentService.delContent(id);
        return bool;
    }
}
