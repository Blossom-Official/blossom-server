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

INSERT INTO CONTENT
    (CONTENT_ID, CREATED_AT, MODIFIED_AT)
VALUES (1, "2023-01-01", "2023-01-01"),
       (2, "2023-01-01", "2023-01-01");

INSERT INTO CONTENT_INFO
(CONTENT_INFO_ID, CONTENT_ID, CONTENT_IMAGE_URL, `ORDER`, LINK_YN, LINK_URL, CREATED_AT, MODIFIED_AT)
VALUES (1, 1, "content 1 image url 1", 1, true, "content 1 link url 1", "2023-01-01", "2023-01-01"),
       (2, 1, "content 1 image url 2", 2, false, NULL, "2023-01-01", "2023-01-01"),
       (3, 1, "content 1 image url 3", 3, false, NULL, "2023-01-01", "2023-01-01"),
       (4, 1, "content 1 image url 4", 4, true, "content 1 link url 4", "2023-01-01", "2023-01-01"),
       (5, 1, "content 1 image url 5", 5, true, "content 1 link url 5", "2023-01-01", "2023-01-01"),
       (6, 2, "content 2 image url 1", 1, true, "content 2 link url 1", "2023-01-01", "2023-01-01"),
       (7, 2, "content 2 image url 2", 2, false, NULL, "2023-01-01", "2023-01-01"),
       (8, 2, "content 2 image url 3", 3, false, NULL, "2023-01-01", "2023-01-01"),
       (9, 2, "content 2 image url 4", 4, true, "content 2 link url 4", "2023-01-01", "2023-01-01"),
       (10, 2, "content 2 image url 5", 5, true, "content 2 link url 5", "2023-01-01", "2023-01-01");
