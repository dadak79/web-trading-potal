package com.webtradingportal.web;

import com.webtradingportal.service.PostsService;
import com.webtradingportal.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller // @RestController 와 @Controller의 차이점 : https://dncjf64.tistory.com/288
public class IndexController {

    private final PostsService postsService;

    //초기화면
    @GetMapping("/")
    public String index(){
        // mustache는 index를 반환하면 *.mustach 파일 확장자가 붙어서 Veiw Resolver가 처리됨
        return "index";
    }

    //게시글 등록화면
    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }

    //게시글 수정화면
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


    //게시글 전체 조회화면
    @GetMapping("/posts/list")
    public String postList(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts-list";
    }

}
