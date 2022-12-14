package com.sparta.homework2.entity;

import com.sparta.homework2.dto.ContentRequestDto;
import com.sparta.homework2.dto.ReturnDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Content extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    public Content(ContentRequestDto requestDto){

        this.title = requestDto.getTitle();
        this.content=requestDto.getContent();
        this.author=requestDto.getAuthor();
        this.password=requestDto.getPassword();
    }

    public ReturnDto Dto(){
        return new ReturnDto(this.getCreatedAt(), this.getModifiedAt(),this.id,this.title,this.content,this.author);
    }

}