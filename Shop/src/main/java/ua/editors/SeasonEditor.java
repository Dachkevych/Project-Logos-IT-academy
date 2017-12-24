package ua.editors;

import java.beans.PropertyEditorSupport;

import ua.entity.Season;
import ua.service.SeasonService;

public class SeasonEditor extends PropertyEditorSupport{
	
	private final SeasonService seasonService;

	public SeasonEditor(SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Season season = seasonService.findOne(Integer.parseInt(text));
		setValue(season);
	}
	
	

}
