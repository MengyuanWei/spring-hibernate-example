CREATE SEQUENCE images_id_seq;
CREATE TABLE images (
    id bigint not null DEFAULT NEXTVAL('images_id_seq'),
    title varchar(255) not NULL,
    url varchar(255) not NULL,
    extension varchar(255) not NULL,
    uuid varchar (255) not NULL,
    user_id bigint DEFAULT NULL,
    primary key (id),
    CONSTRAINT fk_image_user
      FOREIGN KEY (user_id)
      REFERENCES users (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);
ALTER SEQUENCE images_id_seq OWNED BY images.id;