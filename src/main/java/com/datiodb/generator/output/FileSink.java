package com.datiodb.generator.output;

import com.datiodb.generator.producer.Tuple;

public class FileSink implements Sink, SinkIO {
	
	private String path;
	private String filename;
	private String separator;
	private int bufferSize;
	
	private FileSink() {}
	
	public String getPath() {
		return path;
	}

	public String getFilename() {
		return filename;
	}

	public String getSeparator() {
		return separator;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public static Filename path(String path) {
		return new FileSink.Builder();
	}
	
	public interface Filename {
		public Optionals filename(String filename);
	}
	
	public interface Creator {
		public FileSink create();
	}
	
	public interface Optionals extends Creator {
		public Optionals withSeparator(String separator);
		public Optionals bufferSize(int size);
	}
	
	@Override
	public void begin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(Tuple tuple) {
		// TODO Auto-generated method stub
		
	}

	public static class Builder implements Filename, Optionals, Creator {
		
		private FileSink instance=new FileSink();

		@Override
		public FileSink create() {
			return instance;
		}

		@Override
		public Optionals withSeparator(String separator) {
			instance.separator=separator;
			return this;
		}

		@Override
		public Optionals bufferSize(int size) {
			instance.bufferSize=size;
			return this;
		}

		@Override
		public Optionals filename(String filename) {
			instance.filename=filename;
			return this;
		}

	}

}
