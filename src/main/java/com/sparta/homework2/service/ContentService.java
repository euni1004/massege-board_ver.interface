package com.sparta.homework2.service;

import com.sparta.homework2.dto.ContentRequestDto;
import com.sparta.homework2.dto.NewPasswordDto;
import com.sparta.homework2.dto.ReturnDto;
import com.sparta.homework2.entity.Content;
import com.sparta.homework2.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ContentService {


    private final ContentRepository contentRepository;

    public Content createContent(ContentRequestDto contentRequestDto) throws SQLException {
        Content content = new Content(contentRequestDto);
        contentRepository.save(content);
        return content;
    }

    public List<Content> getContents() throws SQLException{
        List<Content> returnDtos = contentRepository.findAllByOrderByModifiedAtDesc();
        return returnDtos;
    }

    public ReturnDto getContent(Long id) throws SQLException{
        ReturnDto returnDto = contentRepository.findById(id).orElse(null).Dto();
        return returnDto;
    }

    public Long delContent(Long id){
        contentRepository.deleteById(id);
        return id;
    }

    public Content updateContent(Long id, ContentRequestDto requestDto){
        Content content = contentRepository.findById(id).orElseThrow(() -> new NullPointerException("해당아이디가 존재하지 않습니다"));

        content.setTitle(requestDto.getTitle());
        content.setContent(requestDto.getContent());
        content.setAuthor(requestDto.getAuthor());
        content.setPassword(requestDto.getPassword());
        contentRepository.save(content);

        return content;
    }

    public boolean checkPw(Long id, NewPasswordDto requestDto) throws SQLException{
        Content content = contentRepository.findById(id).orElse(null);
        if(content.getPassword().equals(requestDto.getPassword())){
            return true;
        }
        return false;
    }
}
