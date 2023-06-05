package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx2 {

	public static void main(String[] args) {
		
//		List<String> list = Arrays.adlist("바둑," "바나나","포도","딸기","바질","강아지");
//		
//		//'바'로 로 시작하는 요소 새로운 추가 후 출력
//List<File> list = new ArrayList<File>();
//
//list.add(new File("c:\\file1.txt"));
//list.add(new File("c:\\file2.txt"));
//list.add(new File("c:\\file3.txt"));
//list.add(new File("c:\\file4.txt"));
//list.add(new File("c:\\file5.txt"));
//		List<String> 

	
	
		//distinct(0 : 중복 제거
		List<String> list2 = Arrays.asList("바둑","바나나","포도","딸기","바질","바둑");
		list2.stream().distinct().forEach(System.out::println);
	
		
		//Arrays.asList(....) : array =>list
		//Stream.of(...) : array=>stream
		Stream<File> stream = Stream.of(new File("d:\\test1.txt"),new File("d:\\test2.txt"),new File("d:\\test3.txt"),new File("d:\\test1.java"),new File("d:\\test1.bak"),new File("d:\\test"));
		
		//peek() : 연산 중간 결과 확인
		//파일 확장자를 추출한 후 중복을 제거하고 출력하기
		//파일명 추출 -> 확장자 추출 -> 확장자만 모음 -> 중복제거 -> 출력
		stream.map(File::getName)
			.filter(f->f.indexOf(".") >-1)
			.peek(f-> System.out.print("필터 통과 후 " +f))
			.map(f->f.substring(f.lastIndexOf(".")+1))
			.distinct()
			.forEach(System.out::println);
		
	}
}









