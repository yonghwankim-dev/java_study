package ch15.ex_14_File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * title : 파일의 속성들을 보여주고 정렬기능을 추가한 예제
 * 시간이나 파일크기, 이름으로 오름차순 도는 내림차순으로 파일목록을 정렬하여 볼 수 있음
 */
public class FileEx {
	public static void main(String[] args) {
		// 입력이 잘못된 경우
		// 1. 인자가 1개가 아닌 경우
		// 2. 입력받은 인자가 1글자가 아닌 경우
		// 3. 입력받은 인자가 tTlLnN에 포함되지 않은 경우
		if(args.length != 1 || args[0].length() != 1 || "tTlLnN".indexOf(args[0]) == -1) {
			System.out.println("USAGE : java FileEx SORT_OPTION   ");
			System.out.println("   SORT_OPTION :                  ");
			System.out.println("   t     Time ascending sort.     ");
			System.out.println("   T     Time descending sort.    ");
			System.out.println("   l     Length ascending sort.   ");
			System.out.println("   L     Length descending sort.  ");
			System.out.println("   n     Name ascending sort.     ");
			System.out.println("   N     Name descending sort.    ");
			System.exit(0);
		}
		
		final char option = args[0].charAt(0);
		
		String currDir = System.getProperty("user.dir");
		File   dir     = new File(currDir);
		File[] files   = dir.listFiles();
		
		Comparator<Object> comp = new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				long time1 = ((File) o1).lastModified();
				long time2 = ((File) o2).lastModified();
				
				long length1 = ((File) o1).length();
				long length2 = ((File) o2).length();
				
				String name1 = ((File) o1).getName().toLowerCase();
				String name2 = ((File) o2).getName().toLowerCase();
				
				int result = 0;
				
				switch(option) {
				case 't':
					if(time1 - time2 > 0) {
						result = 1;
					}else if(time1 - time2 == 0) {
						result = 0;
					}else if(time1 - time2 < 0) {
						result = -1;
					}
					break;
				
				case 'T':
					if(time1 - time2 > 0) {
						result = -1;
					}else if(time1 - time2 == 0) {
						result = 0;
					}else if(time1 - time2 < 0) {
						result = 1;
					}
					break;
					
				case 'l':
					if(length1 - length2 > 0) {
						result = 1;
					}else if(length1 - length2 == 0) {
						result = 0;
					}else if(length1 - length2 < 0) {
						result = -1;
					}
					break;
					
				case 'L':
					if(length1 - length2 > 0) {
						result = -1;
					}else if(length1 - length2 == 0) {
						result = 0;
					}else if(length1 - length2 < 0) {
						result = 1;
					}
					break;
					
				case 'n':
					result = name1.compareTo(name2);
					break;
					
				case 'N':
					result = name2.compareTo(name1);
					break;
				}
				return result;
			}


			@Override
			public boolean equals(Object o) {
				return false; // not used
			}

		}; // end of Comparator
		
		Arrays.sort(files, comp);
		
		for(int i = 0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";
			
			if(files[i].isAbsolute()) {
				attribute = "DIR";
			}else {
				size = f.length() + "";
				attribute =  f.canRead() ? "R" : " ";
				attribute += f.canWrite() ? "W" : " ";
				attribute += f.isHidden() ? "H" : " ";
			}
			
			System.out.printf("%s %3s %6s %s\n"
								, sdf.format(new Date(f.lastModified()))
								, attribute
								, size
								, name);			
		}		
	}
}
