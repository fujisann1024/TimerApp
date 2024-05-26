package com.example.demo.infrastructure.mapper.Usr.outDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/***
 * ユーザー情報取得DTO
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsrOutDto {
	
	private String UserId;
	
	private String UserFirstName;
	
	private String UserLastName;
	
	private String Password;
	
	private int LoginMissCount;
	
	private String AccountLockFlg;
	
	private LocalDateTime LockStartDate;
	
	private LocalDate BirthDay;
	
	private LocalDateTime CreateDate;
	
	private String CreateId;
	
	private LocalDateTime UpdateDate;
	
	private String UpdateId;
}
