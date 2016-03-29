package com.soft2t.imk2tbaseframework.demo.module.demo.database;

import java.io.Serializable;

public class WebInfoShowEntity implements Serializable {
	private static final long serialVersionUID = 5113393882021644497L;

	private String SN;
	private String Title;

	private String Lables;
	// private String AudioPath;
	private String HTML;

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getLables() {
		return Lables;
	}

	public void setLables(String lables) {
		Lables = lables;
	}

	// public String getAudioPath() {
	// return AudioPath;
	// }
	//
	// public void setAudioPath(String audioPath) {
	// AudioPath = audioPath;
	// }

	public String getHTML() {
		return HTML;
	}

	public void setHTML(String hTML) {
		HTML = hTML;
	}
}
