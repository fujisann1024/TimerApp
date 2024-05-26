package com.example.demo.infrastructure.mapper.Usr;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.example.demo.config.DbUnitConfig;
import com.example.demo.config.XlsDataSetLoader;
import com.example.demo.infrastructure.mapper.Usr.outDto.UsrOutDto;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //実データベースの利用
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class, //テスト実行時にSpringのDI機能を利用できるようにする
	 DirtiesContextTestExecutionListener.class, // テストで使用するDIコンテナのライフサイクル管理機能を提供する
	 TransactionalTestExecutionListener.class, //テスト実行時のトランザクション管理機能を提供
	 DbUnitTestExecutionListener.class //DBデータの設定・検証・後処理ができるようにする。@DatabaseSetup,DatabaseTearDown,@ExpectedDatabaseをサポートする
})
@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
@Import(DbUnitConfig.class)
class UsrMapperTest {
	
	private static final String testPath = "/infrastructure/mapper/Usr/";
	
	@Autowired
	private UsrMapper mapper;

	@Test
	@DisplayName("レコード取得 1件")
	@DatabaseSetup(testPath + "Select1_1.xlsx")
	void test() {
		var dto = mapper.selectUserById("0000000000");
		var expectedDto = UsrOutDto.builder()
				.UserId("0000000000")
				.UserFirstName("佐藤")
				.UserLastName("次郎")
				.Password("1Qaz2Wsx@")
				.LoginMissCount(1)
				.AccountLockFlg("A")
				.LockStartDate(LocalDateTime.of(2024, 5,24,19,2,12))
				.BirthDay(LocalDate.of(1996, 2, 5))
				.CreateDate(LocalDateTime.of(2024, 5,25,19,2,12))
				.CreateId("作成者")
				.UpdateDate(LocalDateTime.of(2024, 5,24,19,2,12))
				.UpdateId("更新者")
				.build();
		assertEquals(expectedDto.toString(),dto.toString());
		
	}

}