# SimpleExcelMaker

## 개요
간단하게 xlsx, csv 파일을 생성할 수 있는 라이브러리 입니다.


## 사용법

1. gradle
```
repositories{
  maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.gooinsung:SimpleExcelMaker:{tag}'
}
```

2. maven
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.gooinsung</groupId>
	    <artifactId>SimpleExcelMaker</artifactId>
	    <version>{tag}</version>
	</dependency>
```

의존성 설정 이후
```
        List<User> userList = List.of(
                new User("Alice", 20, "Seoul", "010-1234-5678"),
                new User("Bob", 30, "Busan", "010-2345-6789"),
                new User("Charlie", 40, "Daegu", "010-3456-7890"),
                new User("David", 50, "Incheon", "010-4567-8901"));

        SemInput excelInput = new SemInput.SemInputBuilder()
                .fileName("excel_file")
                .sheetName("excel_sheet")
                .dataList(userList)
                .build();

        SimpleMaker excelMaker = new SimpleExcelMaker();
        excelMaker.make(excelInput);

        SemInput csvInput = new SemInput.SemInputBuilder()
                .fileName("csv_file")
                .sheetName("csv_sheet")
                .dataList(userList)
                .extensionType(ExtensionType.CSV)
                .build();

        SimpleMaker csvMaker = new SimpleCsvMaker();
        csvMaker.make(csvInput);
```

