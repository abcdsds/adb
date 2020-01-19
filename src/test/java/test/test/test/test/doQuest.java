package test.test.test.test;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

import test.test.test.adb.adbCommand;
import test.test.test.opencv.OpenCvService;
import test.test.test.util.uitls;

public class doQuest extends uitls {

	private static String ragnarFilePath = "C:/Users/ds/Downloads/DesKidRagnarLocationXY.json";
	private static String globalFilePath = "C:/Users/ds/Downloads/DesKidGlobalLocationXY.json";
	private static String dayDungeonFilePath = "C:/Users/ds/Downloads/DesKidDayDungeonLocationXY.json";
	private static String mainImgPath = "C:/img/screen2.png";
	private static String defaultPath = "C:/img";
	private static String saveName = "";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//doQuest2("adventure");
		//doQuest2("hotSpa");
		//doQuest2("dayDungeon");
		doQuest2("reverse");

	}

	public static void doQuest2(String questNmae) throws InterruptedException {

		// JSONObject ragnarJo = getJsonObject(ragnarFilePath);
		// System.out.println(ragnarJo.getJSONObject("DesKidRagnarLocationXY").getJSONObject("needTicket").get("1"));

		JSONObject dayDungeonJo = getJsonObject(dayDungeonFilePath).getJSONObject(questNmae);
		Map<String, Object> dayDungeonClickXyMap = dayDungeonJo.getJSONObject("Clickxy").toMap();
		Map<String, Object> dayDungeonCompareXyMap = dayDungeonJo.getJSONObject("Comparexy").toMap();
		String questImgPath = defaultPath + dayDungeonJo.getString("defaultImgPath");
		int quitMapSize = dayDungeonJo.getInt("quitMapSize");
		File f = new File(questImgPath);
		OpenCvService openCv = new OpenCvService();
		adbCommand adb = new adbCommand();
		boolean checkWhile = true;
		String tempName = "";
		String newSaveName = "";

		while (checkWhile) {

			Thread.sleep(1000); //화면 이동될동안 멈출시간
			adb.capture(mainImgPath);
			Thread.sleep(1000); //캡쳐 저장될 시간
			openCv.setMainImg(mainImgPath);

			for (File info : FileUtils.listFiles(f, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {

				System.out.println(questImgPath+info.getName());

				String FilenameWithoutExtension = FilenameUtils.removeExtension(info.getName());
				openCv.setCompareImg(questImgPath+info.getName());
				openCv.calMmr(0); // 0 이 가장 결과값이 좋음

				
				if (dayDungeonClickXyMap.size() <= quitMapSize) {
					Thread.sleep(1000);
					adb.click(dayDungeonClickXyMap.get(questNmae+"Cancel").toString());
					checkWhile = false;
					break;
				}

				if (dayDungeonCompareXyMap.containsKey(FilenameWithoutExtension)) {
					if (openCv.compare("veritical",dayDungeonCompareXyMap.get(FilenameWithoutExtension).toString())) {
						//저장 시킬 키 이름  
						//구역을 지워야 하기때문에 이름에 In 이 들어간것만 추가
						if (FilenameWithoutExtension.indexOf("In") != -1) {
							tempName = FilenameWithoutExtension;
						}
						System.out.println("Found = " + FilenameWithoutExtension);
						adb.click(dayDungeonClickXyMap.get(FilenameWithoutExtension).toString());
						
						if (FilenameWithoutExtension.equals(questNmae+"Cancel") && newSaveName.equals("adventureStart") == false) {
							System.out.println(newSaveName + " 삭제");
							dayDungeonCompareXyMap.remove(newSaveName);
							dayDungeonClickXyMap.remove(newSaveName);
						}
						break;
					} else {
						System.out.println("notFound = " + FilenameWithoutExtension);
					}
				}
				System.out.println("현재 남은 크기 = " +dayDungeonClickXyMap.size());
				openCv.compareImageRelease();
				newSaveName = tempName;

			}

			openCv.mainImageRelease();

		}

		System.out.println("### "+questNmae+" 종료 ###");

	}

}
