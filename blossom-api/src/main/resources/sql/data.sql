INSERT INTO FLOWER
(FLOWER_ID, KOREAN_NAME, ENGLISH_NAME, CATEGORY, FAMILY_NAME, ADDITIONAL_INFORMATION, FIT_NAME, FIT_INFORMATION,
 CREATED_AT, MODIFIED_AT)
VALUES (1, "은방울 꽃", "LILY OF THE VALLEY", "LOVE", "백합과", "꽃과 잎에 독성이 있으므로 꽃 장식을 한 후에는 손을 씻어야 한다.", "압화",
        "일주일간 책 사이에 꽂아두면 돼요, 압화 전용 시트가 있다면 사용해주세요!", "2023-01-01", "2023-01-01"),
       (2, "산데르소니아", "SANDERSONIA", "LOVE", "백합과", "개화가 끝난 꽃을 제거하면 줄기 꽃 봉오리까지 개화합니다.", "드라이플라워",
        "통풍 잘되는 곳에서 말려주어야 벌레가 생기지 않아요. 창문을 열어두고 가급적 햇빛이 들어오지 않도록 신경을 써주세요.", "2023-01-01", "2023-01-01"),
       (3, "레우코코리네", "GLORY OF THE SUN", "CELEBRATE", "백합과", "개화가 끝난 꽃을 제거하면 줄기 꽃 봉오리까지 개화합니다.", "압화",
        "일주일간 책 사이에 꽂아두면 돼요, 압화 전용 시트가 있다면 사용해주세요!", "2023-01-01", "2023-01-01"),
       (4, "리시언더스", "PRAIRIE GENTIAN", "LOVE", "백합과", "습도에 약하기 때문에 꽃잎에는 물을 직접 주지 않는 것이 좋다.", "꽃다발", "꽃다발로 주면 좋아해요.",
        "2023-01-01", "2023-01-01"),
       (5, "마거리트", "MARGUERITE", "LOVE", "국화과", "잎을 적당히 제거해주면 물올림이 좋아진다.", "꽃다발", "꽃다발로 주면 좋아해요.", "2023-01-01",
        "2023-01-01");

INSERT INTO FLOWER_IMAGE
(FLOWER_IMAGE_ID, FLOWER_ID, FLOWER_IMAGE_URL, `ORDER`, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "은방울 꽃 image url 1", 1, "2023-01-01", "2023-01-01"),
       (2, 1, "은방울 꽃 image url 2", 2, "2023-01-01", "2023-01-01"),
       (3, 1, "은방울 꽃 image url 3", 3, "2023-01-01", "2023-01-01"),
       (4, 2, "산데르소니아 image url 1", 1, "2023-01-01", "2023-01-01"),
       (5, 2, "산데르소니아 image url 2", 2, "2023-01-01", "2023-01-01"),
       (6, 2, "산데르소니아 image url 3", 3, "2023-01-01", "2023-01-01"),
       (7, 3, "레우코코리네 image url 1", 1, "2023-01-01", "2023-01-01"),
       (8, 3, "레우코코리네 image url 2", 2, "2023-01-01", "2023-01-01"),
       (9, 3, "레우코코리네 image url 3", 3, "2023-01-01", "2023-01-01"),
       (10, 4, "리시언더스 image url 1", 1, "2023-01-01", "2023-01-01"),
       (11, 4, "리시언더스 image url 2", 2, "2023-01-01", "2023-01-01"),
       (12, 4, "리시언더스 image url 3", 3, "2023-01-01", "2023-01-01"),
       (13, 5, "마거리트 image url 1", 1, "2023-01-01", "2023-01-01"),
       (14, 5, "마거리트 image url 2", 2, "2023-01-01", "2023-01-01"),
       (15, 5, "마거리트 image url 3", 3, "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_TIME
    (FLOWER_TIME_ID, FLOWER_ID, MONTH, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, 5, "2023-01-01", "2023-01-01"),
       (2, 1, 6, "2023-01-01", "2023-01-01"),
       (3, 2, 6, "2023-01-01", "2023-01-01"),
       (4, 2, 7, "2023-01-01", "2023-01-01"),
       (5, 3, 3, "2023-01-01", "2023-01-01"),
       (6, 3, 4, "2023-01-01", "2023-01-01"),
       (7, 4, 6, "2023-01-01", "2023-01-01"),
       (8, 4, 7, "2023-01-01", "2023-01-01"),
       (9, 4, 8, "2023-01-01", "2023-01-01"),
       (10, 5, 3, "2023-01-01", "2023-01-01"),
       (11, 5, 4, "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_TAG
    (FLOWER_TAG_ID, FLOWER_ID, NAME, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "행복", "2023-01-01", "2023-01-01"),
       (2, 1, "사랑", "2023-01-01", "2023-01-01"),
       (3, 1, "연인", "2023-01-01", "2023-01-01"),
       (4, 2, "축하", "2023-01-01", "2023-01-01"),
       (5, 2, "사랑", "2023-01-01", "2023-01-01"),
       (6, 3, "존경", "2023-01-01", "2023-01-01"),
       (7, 3, "축하", "2023-01-01", "2023-01-01"),
       (8, 4, "사랑", "2023-01-01", "2023-01-01"),
       (9, 4, "결혼", "2023-01-01", "2023-01-01"),
       (10, 5, "사랑", "2023-01-01", "2023-01-01"),
       (11, 5, "연인", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_LANGUAGE
    (FLOWER_LANGUAGE_ID, FLOWER_ID, NAME, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "순결", "2023-01-01", "2023-01-01"),
       (2, 1, "다시 찾은 행복", "2023-01-01", "2023-01-01"),
       (3, 2, "성공과 축복", "2023-01-01", "2023-01-01"),
       (4, 2, "순수한 사랑", "2023-01-01", "2023-01-01"),
       (5, 3, "따뜻한 마음", "2023-01-01", "2023-01-01"),
       (6, 4, "변치 않는 사랑", "2023-01-01", "2023-01-01"),
       (7, 5, "진실한 사랑", "2023-01-01", "2023-01-01"),
       (8, 5, "예언", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_CARE
(FLOWER_CARE_ID, FLOWER_ID, INFORMATION, `ORDER`, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "첫번째 순서입니다.", 1, "2023-01-01", "2023-01-01"),
       (2, 1, "두번째 순서입니다.", 2, "2023-01-01", "2023-01-01"),
       (3, 1, "세번째 순서입니다.", 3, "2023-01-01", "2023-01-01"),
       (4, 1, "네번째 순서입니다.", 4, "2023-01-01", "2023-01-01"),
       (5, 2, "첫번째 순서입니다.", 1, "2023-01-01", "2023-01-01"),
       (6, 2, "두번째 순서입니다.", 2, "2023-01-01", "2023-01-01"),
       (7, 2, "세번째 순서입니다.", 3, "2023-01-01", "2023-01-01"),
       (8, 2, "네번째 순서입니다.", 4, "2023-01-01", "2023-01-01"),
       (9, 3, "첫번째 순서입니다.", 1, "2023-01-01", "2023-01-01"),
       (10, 3, "두번째 순서입니다.", 2, "2023-01-01", "2023-01-01"),
       (11, 3, "세번째 순서입니다.", 3, "2023-01-01", "2023-01-01"),
       (12, 3, "네번째 순서입니다.", 4, "2023-01-01", "2023-01-01"),
       (13, 4, "첫번째 순서입니다.", 1, "2023-01-01", "2023-01-01"),
       (14, 4, "두번째 순서입니다.", 2, "2023-01-01", "2023-01-01"),
       (15, 4, "세번째 순서입니다.", 3, "2023-01-01", "2023-01-01"),
       (16, 4, "네번째 순서입니다.", 4, "2023-01-01", "2023-01-01"),
       (17, 5, "첫번째 순서입니다.", 1, "2023-01-01", "2023-01-01"),
       (18, 5, "두번째 순서입니다.", 2, "2023-01-01", "2023-01-01"),
       (19, 5, "세번째 순서입니다.", 3, "2023-01-01", "2023-01-01"),
       (20, 5, "네번째 순서입니다.", 4, "2023-01-01", "2023-01-01");

INSERT INTO BETTER_TOGETHER
(BETTER_TOGETHER_ID, FLOWER_ID, BETTER_TOGETHER_FLOWER_ID, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, 2, "2023-01-01", "2023-01-01"),
       (2, 1, 3, "2023-01-01", "2023-01-01"),
       (3, 2, 1, "2023-01-01", "2023-01-01"),
       (4, 2, 3, "2023-01-01", "2023-01-01"),
       (5, 3, 1, "2023-01-01", "2023-01-01"),
       (6, 3, 2, "2023-01-01", "2023-01-01"),
       (7, 4, 1, "2023-01-01", "2023-01-01"),
       (8, 4, 2, "2023-01-01", "2023-01-01"),
       (9, 5, 1, "2023-01-01", "2023-01-01"),
       (10, 5, 2, "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_CONTENT
    (FLOWER_CONTENT_ID, FLOWER_ID, CONTENT_ID, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, 1, "2023-01-01", "2023-01-01"),
       (2, 2, 1, "2023-01-01", "2023-01-01"),
       (3, 3, 1, "2023-01-01", "2023-01-01"),
       (4, 4, 1, "2023-01-01", "2023-01-01"),
       (5, 5, 1, "2023-01-01", "2023-01-01");

INSERT INTO CONTENT
(CONTENT_ID, TITLE, SUBTITLE, DESCRIPTION, CONTENT_THUMBNAIL_URL, CONTENT_IMAGE_URL, POSTED_AT, CREATED_AT, MODIFIED_AT)
VALUES (1, "ONE DAY CLASS", "봄에는 꽃과 함께 기분전환",
        "이번 봄에는 Blossom이 추천해 주는 꽃꽂이 원 데이 클래스를 경험해 보는 건 어때요? 봄과 어울리는 다양한 꽃들로 칙칙한 나의 일상을 칠해보세요. 꽃 다발 하나로 바뀌는 방 분위기에 놀라게 될 거예요!",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1_main_s.png",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1_main.png", "2023.06.27",
        "2023-01-01", "2023-01-01"),
       (2, "AUTUMN COSMOS", "가을의 꽃 코스모스, 꽃놀이 명소 추천",
        "이번 가을에는 Blossom이 추천하는 꽃놀이 명소들을 둘러보는 건 어때요? 가을꽃에서만 느껴지는 잔잔함으로 감성을 충전해 보아요. 곧 불어올 찬 바람에 우리를 대비해 줄거에요.",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1_main_s.png",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents2_main.png", "2023.09.15",
        "2023-01-01", "2023-01-01"),
       (3, "FLOWER CAKES", "꽃을 좋아하는 당신을 위해,",
        "특별한 날에 빠질 수 없는 케이크! 사계절 내내 맛있게 만나볼 수 있는 꽃 케이크는 어때요? 블라썸이 추천하는 서울의 꽃 케이크 전문점들로 소중한 날을 더욱 향기롭게 즐겨보아요.",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1_main_s.png",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents3_main.png", "2023.10.09",
        "2023-01-01", "2023-01-01");

INSERT INTO CONTENT_INFORMATION
(CONTENT_INFORMATION_ID, CONTENT_ID, TITLE, SUBTITLE, DESCRIPTION, CONTENT_IMAGE_URL, `ORDER`, LINK_YN, LINK_URL,
 CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "클래스 아홈", "서울 성동구 성수일로3길 5-15",
        "꽃꽂이의 핵심이자 기초인 꽃다발(handtied)을 만들기 위한 수업이에요. 가장 기본인 라운드 형태의 꽃다발을 제작하고, 포장하는 방법을 배워요.",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1-1.png",
        2, true, "https://www.class-arum.co.kr/Home/?idx=7", "2023-01-01", "2023-01-01"),
       (2, 1, "블루 에떼", "서울 마포구 독막로9길 41 1,2층(서교동)",
        "1층은 꽃집, 2층은 카페/펍으로 운영하고 있는 곳이에요. 방문하면 꽃을 주는 카페로 유명하지만, 전문 플로리스트가 진행하는 플라워 클래스로 꽃을 손질하는 방법부터 포장하는 방법까지 디테일하게 설명을 들을 수 있어요!",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1-2.png", 3, false, null,
        "2023-01-01", "2023-01-01"),
       (3, 1, "마모아띠에", "서울 성동구 상원길 22 3층",
        "평범한 꽃꽂이가 질린다면? 케이커리의 케이크에 플라워를 디자인하여 데코를 하는 수업도 있어요! 내가 직접 디자인한 플라워를 케이크에 얹을 수 있다니 너무 낭만적이지 않나요?",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1-3.png", 4, true,
        "https://www.mamoitie.kr/shop_view/?idx=47", "2023-01-01", "2023-01-01"),
       (4, 1, "무아 플라워스튜디오", "서울 종로구 필운대로 51 3층",
        "핸드타이드, 화병 꽂이, 화기 꽂이, 서머 바스켓, 플라워 박스까지! 주말 오전과 오후에 항상 열려있는 무아의 원 데이 클래스에서 만들어보고 시도해 보고 싶었던 꽃 디자인을 모두 체험해 보아요!",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents1-4.png", 5, true,
        "https://www.instagram.com/mua_flowerstudio/", "2023-01-01", "2023-01-01"),
       (5, 2, "서울 올림픽공원", "서울 송파구 올림픽로 424",
        "서울에서 보기 드문 뻥 뚫린 뷰를 즐길 수 있는 올림픽공원에서 가을에 코스모스도 만나보아요. 양쪽으로 코스모스가 펼쳐진 길을 걸으면서 인생샷도 건질 수 있어요!",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents2-1.png",
        2, false, null, "2023-01-01", "2023-01-01"),
       (6, 2, "인천 하늘정원", "인천광역시 중구 운서동 2848-1",
        "봄에는 유채꽃 명소로 알려진 하늘정원, 가을에는 코스모스, 억새 그리고 핑크뮬리로 더 풍성한 가을을 즐겨보아요! 사람이 적어 조용하게 산책하러 가기 딱 좋아요.",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents2-2.png", 3, false, null,
        "2023-01-01", "2023-01-01"),
       (7, 2, "파주 율곡습지 공원", "경기 파주시 파평면 율곡리 191-3",
        "코스모스밭 안에 길이 트여있어서 꽃에 둘러싸인 느낌을 받을 수 있는 장소에요. 넓은 코스모스밭으로 눈에 가을을 듬뿍 담을 수 있어요!",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents2-3.png", 4, false, null,
        "2023-01-01", "2023-01-01"),
       (8, 2, "공주 미르섬", "충남 공주시 금벽로 368",
        "산책로와 피크닉 장소로도 이용되는 곳이니 나무 아래 그늘진 곳에서 천천히 쉬면서 꽃구경도 해보아요. 잔잔한 바람에 흩날리는 코스모스로 가을을 만끽해 보아요.",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents2-4.png", 5, false, null,
        "2023-01-01", "2023-01-01"),
       (9, 3, "아네모네시", "마포구 동교동 153-23 1층 파란문",
        "아네모네시의 유니크함이 확 느껴지는 시그니처 젤리밤 케이크는 어때요? 주문은 인스타 DM과 네이버 예약으로 받고 있으니 인스타 스토리 하이라이트와 피드를 확인하고 디자인을 정해보아요.",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents3-1.png",
        2, true, "https://www.instagram.com/anemonesi/", "2023-01-01", "2023-01-01"),
       (10, 3, "샘케이크", "서울 성북구 정릉로 34길 11 1층",
        "이미 정릉에선 100% 쌀베이킹 빵으로 유명한 샘케이크! 눈과 입이 행복해지는 샘케이크의 케이크도 한 번 둘러보세요, 생화 케이크뿐만 아니라 꽃잎으로 백조의 우아한 깃털을 표현하며 만든 백조 케이크도 있어요!",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents3-2.png", 3, true,
        "https://www.instagram.com/sam.cake_/?img_index=1",
        "2023-01-01", "2023-01-01"),
       (11, 3, "달꼬미", "서울특별시 강남구 삼성로63길 13",
        "알록달록 수국이 올라간 케이크는 어때요? 꽃 시장에서 바로 픽업 해온 꽃의 향기에 취해보아요. 요즘 유행인 발레리나 코어에 맞게 리본 케이크도 판매 중이니 함께 둘러보세요!",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents3-3.png", 4, true,
        "https://www.instagram.com/dalccomi_/",
        "2023-01-01", "2023-01-01"),
       (12, 3, "오렌지케이크메이커", "서울특별시 마포구 월드컵로11길 80",
        "진한 우유 맛 생크림과 생화의 조화를 이룬 오렌지케이크메이커의 케이크! 롤부터 카니컬 쉐입, 컵케이크까지 다양한 형태로 준비되어 있어 선물용으로도 좋아요.",
        "https://blossom-public-dev.s3.ap-northeast-2.amazonaws.com/content-image/contents3-4.png", 5, true,
        "https://www.instagram.com/orangecakemaker/",
        "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_RECOMMEND_RELATIONSHIP
(FLOWER_RECOMMEND_RELATIONSHIP_ID, FLOWER_ID, RELATIONSHIP, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "FRIEND", "2023-01-01", "2023-01-01"),
       (2, 2, "LOVER", "2023-01-01", "2023-01-01"),
       (3, 3, "LOVER", "2023-01-01", "2023-01-01"),
       (4, 4, "FAMILY", "2023-01-01", "2023-01-01"),
       (5, 5, "ACQUAINTANCE", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_RECOMMEND_AGE
    (FLOWER_RECOMMEND_AGE_ID, FLOWER_ID, AGE, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "TWENTY", "2023-01-01", "2023-01-01"),
       (2, 2, "TWENTY", "2023-01-01", "2023-01-01"),
       (3, 3, "THIRTY", "2023-01-01", "2023-01-01"),
       (4, 4, "FORTY", "2023-01-01", "2023-01-01"),
       (5, 5, "ABOVE", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_RECOMMEND_MIND
    (FLOWER_RECOMMEND_MIND_ID, FLOWER_ID, MIND, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "GREETING", "2023-01-01", "2023-01-01"),
       (2, 2, "RESPECT", "2023-01-01", "2023-01-01"),
       (3, 3, "THANKS", "2023-01-01", "2023-01-01"),
       (4, 4, "LOVE", "2023-01-01", "2023-01-01"),
       (5, 5, "CONSOLATION", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_RECOMMEND_COLOR
    (FLOWER_RECOMMEND_COLOR_ID, FLOWER_ID, COLOR, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "RED_ORANGE", "2023-01-01", "2023-01-01"),
       (2, 2, "RED_ORANGE", "2023-01-01", "2023-01-01"),
       (3, 3, "RED_ORANGE", "2023-01-01", "2023-01-01"),
       (4, 4, "GREEN", "2023-01-01", "2023-01-01"),
       (5, 5, "BLUE_PURPLE", "2023-01-01", "2023-01-01");

INSERT INTO FLOWER_RECOMMEND_SEASON
(FLOWER_RECOMMEND_SEASON_ID, FLOWER_ID, SEASON, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "SPRING", "2023-01-01", "2023-01-01"),
       (2, 2, "SUMMER", "2023-01-01", "2023-01-01"),
       (3, 3, "SUMMER", "2023-01-01", "2023-01-01"),
       (4, 4, "AUTUMN", "2023-01-01", "2023-01-01"),
       (5, 5, "WINTER", "2023-01-01", "2023-01-01");