
-- 게시글
insert into article (title, content, hashtag, created_by, modified_by, created_at, modified_at) values
                                                                                                    ( 'Quisque ut erat.', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.

Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.

', '#pink', 'Kamilah', 'Murial', '2021-05-30 23:53:46', '2021-03-10 08:48:50'),
                                                                                                    ( 'Morbi ut odio.', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.

Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.

Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.

', '#purple', 'Arv', 'Keelby', '2021-05-06 11:51:24', '2021-05-23 08:34:54'),
                                                                                                    ( 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.

', '#purple', 'Adams', 'Thalia', '2021-08-13 08:32:22', '2021-04-02 02:58:19');

-- 댓글
insert into article_comment (article_id, content, created_at, modified_at, created_by, modified_by) values
    (2, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2021-03-02 22:40:04', '2021-04-27 15:38:09', 'Lind', 'Orv'),
    (1, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2021-06-08 04:36:02', '2022-01-25 15:35:42', 'Trstram', 'Loy'),
    (3, 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', '2021-04-10 00:47:10', '2021-02-06 20:58:04', 'Duff', 'Early'),
    (2, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.', '2021-08-21 08:39:39', '2021-11-17 22:47:35', 'Sydney', 'Boony'),
    (2, 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', '2021-06-17 10:57:29', '2021-05-13 12:28:47', 'Burk', 'Markus');



