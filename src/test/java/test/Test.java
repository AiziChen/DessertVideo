package test;

import java.io.IOException;
import java.text.ParseException;

import quanye.dessertvideo.domain.Video;
import quanye.dessertvideo.parser.ParseAllVideo;
import quanye.dessertvideo.tools.Tools;

public class Test {
	public static void main(String[] args) throws ParseException, IOException {
		ParseAllVideo.getInstance().parse();
	}
}
