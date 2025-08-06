create table if not exists public.group(
    id UUID not null,
    group_name VARCHAR(50) not null,
    group_creation_date DATE not null,
    primary key (id)
);

create table if not exists public.user(
    id UUID not null,
    first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
    username VARCHAR(50) not null,
    password VARCHAR(50) not null,
    email VARCHAR(50) not null,
    user_creation_date DATE not null,
    primary key (id)
);

create table if not exists public.post(
    id UUID not null,
    user_id UUID not null,
    group_id UUID not null,
    title VARCHAR(100) not null,
    content TEXT not null,
    post_creation_date_time TIMESTAMP not null,
    primary key (id),
    foreign key (user_id) references public.user (id),
    foreign key (group_id) references public.group (id)
);

create table if not exists public.comment(
    id UUID not null,
    user_id UUID not null,
    group_id UUID not null,
    content TEXT not null,
    comment_creation_date_time TIMESTAMP not null,
    primary key (id),
    foreign key (user_id) references public.user (id),
    foreign key (group_id) references public.group (id)
);

create table if not exists public.user_group(
    id UUID not null,
    user_id UUID not null,
    group_id UUID not null,
    role VARCHAR(50) not null,
    primary key (id),
    UNIQUE (user_id, group_id),
    foreign key (user_id) references public.user (id),
    foreign key (group_id) references public.group (id)
);