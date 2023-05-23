package com.spring.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter@ToString
public class ReplyDTO {
 private int rno;
 private int bno;
 private String reply;
 private String replyer;
 private Date replydate;
}
