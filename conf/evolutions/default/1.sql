# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table constituency (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  population                bigint,
  state                     varchar(255),
  parliament                tinyint(1) default 0,
  constraint pk_constituency primary key (id))
;

create table education (
  id                        bigint auto_increment not null,
  education                 varchar(255),
  almamater                 varchar(255),
  constraint pk_education primary key (id))
;

create table election (
  id                        bigint auto_increment not null,
  dateofelection            datetime,
  electionresult_id         bigint,
  constraint pk_election primary key (id))
;

create table election_result (
  id                        bigint auto_increment not null,
  constraint pk_election_result primary key (id))
;

create table family (
  id                        bigint auto_increment not null,
  constraint pk_family primary key (id))
;

create table media (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_media primary key (id))
;

create table person (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  dateofbirth               datetime,
  placeofbirth              varchar(255),
  picture                   varchar(255),
  constraint pk_person primary key (id))
;

create table political_party (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  dateofformation           datetime,
  constraint pk_political_party primary key (id))
;

create table politician (
  id                        bigint auto_increment not null,
  person_id                 bigint,
  currentconstituency_id    bigint,
  currentpoliticalparty_id  bigint,
  education_id              bigint,
  family_id                 bigint,
  profession_id             bigint,
  media_id                  bigint,
  constraint pk_politician primary key (id))
;

create table profession (
  id                        bigint auto_increment not null,
  profession                varchar(255),
  constraint pk_profession primary key (id))
;


create table election_politician (
  election_id                    bigint not null,
  politician_id                  bigint not null,
  constraint pk_election_politician primary key (election_id, politician_id))
;

create table election_result_politician (
  election_result_id             bigint not null,
  politician_id                  bigint not null,
  constraint pk_election_result_politician primary key (election_result_id, politician_id))
;

create table politician_constituency (
  politician_id                  bigint not null,
  constituency_id                bigint not null,
  constraint pk_politician_constituency primary key (politician_id, constituency_id))
;

create table politician_election (
  politician_id                  bigint not null,
  election_id                    bigint not null,
  constraint pk_politician_election primary key (politician_id, election_id))
;

create table politician_political_party (
  politician_id                  bigint not null,
  political_party_id             bigint not null,
  constraint pk_politician_political_party primary key (politician_id, political_party_id))
;
alter table election add constraint fk_election_electionresult_1 foreign key (electionresult_id) references election_result (id) on delete restrict on update restrict;
create index ix_election_electionresult_1 on election (electionresult_id);
alter table politician add constraint fk_politician_person_2 foreign key (person_id) references person (id) on delete restrict on update restrict;
create index ix_politician_person_2 on politician (person_id);
alter table politician add constraint fk_politician_currentconstituency_3 foreign key (currentconstituency_id) references constituency (id) on delete restrict on update restrict;
create index ix_politician_currentconstituency_3 on politician (currentconstituency_id);
alter table politician add constraint fk_politician_currentpoliticalparty_4 foreign key (currentpoliticalparty_id) references political_party (id) on delete restrict on update restrict;
create index ix_politician_currentpoliticalparty_4 on politician (currentpoliticalparty_id);
alter table politician add constraint fk_politician_education_5 foreign key (education_id) references education (id) on delete restrict on update restrict;
create index ix_politician_education_5 on politician (education_id);
alter table politician add constraint fk_politician_family_6 foreign key (family_id) references family (id) on delete restrict on update restrict;
create index ix_politician_family_6 on politician (family_id);
alter table politician add constraint fk_politician_profession_7 foreign key (profession_id) references profession (id) on delete restrict on update restrict;
create index ix_politician_profession_7 on politician (profession_id);
alter table politician add constraint fk_politician_media_8 foreign key (media_id) references media (id) on delete restrict on update restrict;
create index ix_politician_media_8 on politician (media_id);



alter table election_politician add constraint fk_election_politician_election_01 foreign key (election_id) references election (id) on delete restrict on update restrict;

alter table election_politician add constraint fk_election_politician_politician_02 foreign key (politician_id) references politician (id) on delete restrict on update restrict;

alter table election_result_politician add constraint fk_election_result_politician_election_result_01 foreign key (election_result_id) references election_result (id) on delete restrict on update restrict;

alter table election_result_politician add constraint fk_election_result_politician_politician_02 foreign key (politician_id) references politician (id) on delete restrict on update restrict;

alter table politician_constituency add constraint fk_politician_constituency_politician_01 foreign key (politician_id) references politician (id) on delete restrict on update restrict;

alter table politician_constituency add constraint fk_politician_constituency_constituency_02 foreign key (constituency_id) references constituency (id) on delete restrict on update restrict;

alter table politician_election add constraint fk_politician_election_politician_01 foreign key (politician_id) references politician (id) on delete restrict on update restrict;

alter table politician_election add constraint fk_politician_election_election_02 foreign key (election_id) references election (id) on delete restrict on update restrict;

alter table politician_political_party add constraint fk_politician_political_party_politician_01 foreign key (politician_id) references politician (id) on delete restrict on update restrict;

alter table politician_political_party add constraint fk_politician_political_party_political_party_02 foreign key (political_party_id) references political_party (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table constituency;

drop table education;

drop table election;

drop table election_politician;

drop table election_result;

drop table election_result_politician;

drop table family;

drop table media;

drop table person;

drop table political_party;

drop table politician;

drop table politician_constituency;

drop table politician_election;

drop table politician_political_party;

drop table profession;

SET FOREIGN_KEY_CHECKS=1;

