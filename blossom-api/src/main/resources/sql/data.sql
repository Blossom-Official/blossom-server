INSERT INTO FLOWER
(FLOWER_ID, KOREAN_NAME, ENGLISH_NAME, CATEGORY, FAMILY_NAME, ADDITIONAL_INFORMATION, FIT_NAME, FIT_INFORMATION,
 CREATED_AT, MODIFIED_AT)
VALUES (1, "은방울 꽃", "LILY OF THE VALLEY", "LOVE", "백합과", "꽃과 잎에 독성이 있으므로 꽃 장식을 한 후에는 손을 씻어야 한다.", "압화",
        "일주일간 책 사이에 꽂아두면 돼요, 압화 전용 시트가 있다면 사용해주세요!", "2023-01-01", "2023-01-01"),
       (2, "산데르소니아", "SANDERSONIA", "LOVE", "백합과(콜키쿰과)", "개화가 끝난 꽃을 제거하면 줄기 꽃 봉오리까지 개화합니다.", "드라이플라워",
        "통풍 잘되는 곳에서 말려주어야 벌레가 생기지 않아요. 창문을 열어두고 가급적 햇빛이 들어오지 않도록 신경을 써주세요.", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_IMAGE
(FLOWER_IMAGE_ID, FLOWER_ID, FLOWER_IMAGE_URL, `ORDER`, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "은방울 꽃 image url 1", 1, "2023-01-01", "2023-01-01"),
       (2, 1, "은방울 꽃 image url 2", 2, "2023-01-01", "2023-01-01"),
       (3, 1, "은방울 꽃 image url 3", 3, "2023-01-01", "2023-01-01"),
       (4, 2, "산데르소니아 image url 1", 1, "2023-01-01", "2023-01-01"),
       (5, 2, "산데르소니아 image url 2", 2, "2023-01-01", "2023-01-01"),
       (6, 2, "산데르소니아 image url 3", 3, "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_TIME
    (FLOWER_TIME_ID, FLOWER_ID, MONTH, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, 5, "2023-01-01", "2023-01-01"),
       (2, 1, 6, "2023-01-01", "2023-01-01"),
       (3, 2, 6, "2023-01-01", "2023-01-01"),
       (4, 2, 7, "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_TAG
    (FLOWER_TAG_ID, FLOWER_ID, NAME, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "결혼", "2023-01-01", "2023-01-01"),
       (2, 1, "연인", "2023-01-01", "2023-01-01"),
       (3, 2, "축복", "2023-01-01", "2023-01-01"),
       (4, 2, "사랑", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_LANGUAGE
    (FLOWER_LANGUAGE_ID, FLOWER_ID, NAME, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "순결", "2023-01-01", "2023-01-01"),
       (2, 1, "다시 찾은 행복", "2023-01-01", "2023-01-01"),
       (3, 2, "성공과 축복", "2023-01-01", "2023-01-01"),
       (4, 2, "순수한 사랑", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_CARE
(FLOWER_CARE_ID, FLOWER_ID, INFORMATION, `ORDER`, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "첫번째 순서입니다.", 1, "2023-01-01", "2023-01-01"),
       (2, 1, "두번째 순서입니다.", 2, "2023-01-01", "2023-01-01"),
       (3, 1, "세번째 순서입니다.", 3, "2023-01-01", "2023-01-01"),
       (4, 1, "네번째 순서입니다.", 4, "2023-01-01", "2023-01-01"),
       (5, 2, "첫번째 순서입니다.", 1, "2023-01-01", "2023-01-01"),
       (6, 2, "두번째 순서입니다.", 2, "2023-01-01", "2023-01-01"),
       (7, 2, "세번째 순서입니다.", 3, "2023-01-01", "2023-01-01"),
       (8, 2, "네번째 순서입니다.", 4, "2023-01-01", "2023-01-01");

INSERT INTO BETTER_TOGETHER
(BETTER_TOGETHER_ID, FLOWER_ID, BETTER_TOGETHER_FLOWER_ID, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, 2, "2023-01-01", "2023-01-01"),
       (2, 2, 1, "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_CONTENT
    (FLOWER_CONTENT_ID, FLOWER_ID, CONTENT_ID, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, 1, "2023-01-01", "2023-01-01"),
       (2, 2, 1, "2023-01-01", "2023-01-01");

INSERT INTO CONTENT
(CONTENT_ID, TITLE, SUBTITLE, DESCRIPTION, CONTENT_IMAGE_URL, POSTED_AT, CREATED_AT, MODIFIED_AT)
VALUES (1, "ONE DAY CLASS", "봄에는 꽃과 함께 기분전환",
        "이번 봄에는 Blossom이 추천해 주는 꽃꽂이 원 데이 클래스를 경험해 보는 건 어때요? 봄과 어울리는 다양한 꽃들로 칙칙한 나의 일상을 칠해보세요. 꽃 다발 하나로 바뀌는 방 분위기에 놀라게 될 거예요!",
        "content 1 image url 1", "2023-06-27", "2023-01-01", "2023-01-01");

INSERT INTO CONTENT_INFORMATION
(CONTENT_INFORMATION_ID, CONTENT_ID, TITLE, SUBTITLE, DESCRIPTION, CONTENT_IMAGE_URL, `ORDER`, LINK_YN, LINK_URL,
 CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "클래스 아홈", "서울 성동구 성수일로3길 5-15",
        "꽃꽂이의 핵심이자 기초인 꽃다발(handtied)을 만들기 위한 수업이에요. 가장 기본인 라운드 형태의 꽃다발을 제작하고, 포장하는 방법을 배워요.", "content 1 image url 2",
        2, true, "https://www.class-arum.co.kr/Home/?idx=7", "2023-01-01", "2023-01-01"),
       (2, 1, "블루 에떼", "서울 마포구 독막로9길 41 1,2층(서교동)",
        "1층은 꽃집, 2층은 카페/펍으로 운영하고 있는 곳이에요. 방문하면 꽃을 주는 카페로 유명하지만, 전문 플로리스트가 진행하는 플라워 클래스로 꽃을 손질하는 방법부터 포장하는 방법까지 디테일하게 설명을 들을 수 있어요!",
        "content 1 image url 3", 3, false, null, "2023-01-01", "2023-01-01"),
       (3, 1, "마모아띠에", "서울 성동구 상원길 22 3층",
        "평범한 꽃꽂이가 질린다면? 케이커리의 케이크에 플라워를 디자인하여 데코를 하는 수업도 있어요! 내가 직접 디자인한 플라워를 케이크에 얹을 수 있다니 너무 낭만적이지 않나요?",
        "content 1 image url 4", 4, true, "https://www.mamoitie.kr/shop_view/?idx=47", "2023-01-01", "2023-01-01"),
       (4, 1, "무아 플라워스튜디오", "서울 종로구 필운대로 51 3층",
        "핸드타이드, 화병 꽂이, 화기 꽂이, 서머 바스켓, 플라워 박스까지! 주말 오전과 오후에 항상 열려있는 무아의 원 데이 클래스에서 만들어보고 시도해 보고 싶었던 꽃 디자인을 모두 체험해 보아요!",
        "content 1 image url 5", 5, true, "https://www.instagram.com/mua_flowerstudio/", "2023-01-01", "2023-01-01");