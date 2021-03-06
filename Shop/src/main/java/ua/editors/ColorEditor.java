package ua.editors;

import java.beans.PropertyEditorSupport;

import ua.entity.Color;
import ua.service.ColorService;

public class ColorEditor extends PropertyEditorSupport{
	
	private final ColorService colorService;

	public ColorEditor(ColorService colorService) {
		this.colorService = colorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Color color = colorService.findOne(Integer.parseInt(text));
		setValue(color);
	}
	
	

}
