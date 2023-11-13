
use posts;

create table categories
(
    category_id int auto_increment primary key,
    name        varchar(50) not null
);

create table users
(
    user_id    int auto_increment primary key,
    username   varchar(50) not null,
    password   varchar(500) not null,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    email      varchar(50) not null,
    is_admin   boolean     not null
);

create table posts
(
    post_id      int auto_increment primary key,
    title        varchar(50) not null,
    content      varchar(255) not null,
    category_id  int not null,
    created_by   int not null,
    constraint posts_categories_category_id_fk
        foreign key (category_id) references categories (category_id),
    constraint posts_users_user_id_fk
        foreign key (created_by) references users (user_id)
);

