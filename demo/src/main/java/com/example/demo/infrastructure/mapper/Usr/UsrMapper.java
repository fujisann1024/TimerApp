package com.example.demo.infrastructure.mapper.Usr;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.infrastructure.mapper.Usr.outDto.UsrOutDto;

@Mapper
public interface UsrMapper {

	public UsrOutDto selectUserById(String userId);
}
