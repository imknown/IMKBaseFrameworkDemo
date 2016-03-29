package com.soft2t.imk2tbaseframework.demo.module.demo.database;

import java.util.ArrayList;
import java.util.List;

import com.soft2t.imk2tbaseframework.base.BaseApplication;

import android.database.Cursor;

public class DiseaseSelfCheckDao {

	public List<DiseaseSelfCheckPartEntity> getPartEntityList() {
		List<DiseaseSelfCheckPartEntity> diseaseSelfCheckPartEntityList = new ArrayList<DiseaseSelfCheckPartEntity>();

		String sql = "SELECT * FROM DiseasePlace AS d ORDER BY d.OrderNo ASC";
		String[] args = new String[] {};

		DiseaseSelfCheckPartEntity diseaseSelfCheckPartEntity;
		Cursor cursor = BaseApplication.getSQLiteDatabaseInstance().rawQuery(sql, args);
		while (cursor.moveToNext()) {
			diseaseSelfCheckPartEntity = new DiseaseSelfCheckPartEntity();
			diseaseSelfCheckPartEntity.setSN(cursor.getString(cursor.getColumnIndex("SN")));
			diseaseSelfCheckPartEntity.setPlaceName(cursor.getString(cursor.getColumnIndex("PlaceName")));
			diseaseSelfCheckPartEntity.setOrderNo(cursor.getInt(cursor.getColumnIndex("OrderNo")));

			diseaseSelfCheckPartEntityList.add(diseaseSelfCheckPartEntity);
		}

		cursor.close();

		return diseaseSelfCheckPartEntityList;
	}

	public List<DiseaseSelfCheckDescEntity> getPartDescEntityList(String bodyPart, String gender) {
		List<DiseaseSelfCheckDescEntity> selfCheckDescEntityList = new ArrayList<DiseaseSelfCheckDescEntity>();

		String sql = "SELECT d.* FROM Disease AS d, DiseasePlace AS dp WHERE dp.SN = d.PlaceSN ";
		sql += " AND dp.PlaceName = ? AND (d.gender = '所有' OR d.gender = ?)  ORDER BY OrderNo ASC";
		String[] args = new String[] { bodyPart, gender };

		DiseaseSelfCheckDescEntity diseaseSelfCheckDescEntity;
		Cursor cursor = BaseApplication.getSQLiteDatabaseInstance().rawQuery(sql, args);
		while (cursor.moveToNext()) {
			diseaseSelfCheckDescEntity = new DiseaseSelfCheckDescEntity();
			diseaseSelfCheckDescEntity.setSN(cursor.getString(cursor.getColumnIndex("SN")));
			diseaseSelfCheckDescEntity.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
			diseaseSelfCheckDescEntity.setPlaceSN(cursor.getString(cursor.getColumnIndex("PlaceSN")));
			diseaseSelfCheckDescEntity.setGender(cursor.getString(cursor.getColumnIndex("Gender")));
			diseaseSelfCheckDescEntity.setLables(cursor.getString(cursor.getColumnIndex("Lables")));
			// diseaseSelfCheckDescEntity.setAudioPath(cursor.getString(cursor.getColumnIndex("AudioPath")));
			diseaseSelfCheckDescEntity.setHTML(cursor.getString(cursor.getColumnIndex("HTML")));
			diseaseSelfCheckDescEntity.setOrderNo(cursor.getInt(cursor.getColumnIndex("OrderNo")));

			selfCheckDescEntityList.add(diseaseSelfCheckDescEntity);
		}

		cursor.close();

		return selfCheckDescEntityList;
	}
}
