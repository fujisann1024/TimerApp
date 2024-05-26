package com.example.demo.config;

import java.io.InputStream;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;

/**
 * デフォルトではXMLからデータを読み取る仕様のためExcelを読み込む用のDataSetLoaderを用意
 */
public class XlsDataSetLoader extends AbstractDataSetLoader{

	@Override
	protected IDataSet createDataSet(Resource resource) throws Exception {
		try(InputStream inputStream = resource.getInputStream()){
			return new XlsDataSet(inputStream);
		}
		
	}	
}
