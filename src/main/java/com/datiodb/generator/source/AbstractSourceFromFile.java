package com.datiodb.generator.source;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class AbstractSourceFromFile implements SourceFrom {
	
	private String pathToFile;
	
	public AbstractSourceFromFile(String pathToFile) {
		this.pathToFile=pathToFile;
	}
	
	@Override
	public List<?> getOptionList() {
		Path path=Paths.get(getClass().getClassLoader().getResource(pathToFile).getFile());
		try {
			return Files.readAllLines(path,StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

}
