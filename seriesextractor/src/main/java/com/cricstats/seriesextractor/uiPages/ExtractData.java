package com.cricstats.seriesextractor.uiPages;

import java.util.HashMap;
import java.util.List;

import com.cricstats.seriesextractor.App;
import com.cricstats.seriesextractor.dbUtils.DatabaseFunctions;

public class ExtractData extends App {

	public static void get_T20_SeriesData() {
		T20SeriesPage seriesInfo = new T20SeriesPage();
		try {
			List<HashMap<String, String>> seriesInfoList = seriesInfo.getSeriesListInfo();
			DatabaseFunctions.insertSeriesInfo(seriesInfoList);
			seriesInfo.getEachMatchInfo();
			DatabaseFunctions.insertMatchInfo(seriesScorecardsList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
