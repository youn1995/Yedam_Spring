package com.yedam.app.board;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BoardVo {
   private Integer boardNo;
   private String poster;
   private String subject;
   private String boardContents;
   private String lastpost;
   private String views;
   private String filename;
   private String sortCol;
   private List<String> nos;
   private int first;
   private int last;
}