# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table constituency (
  constituency_id           bigint auto_increment not null,
  name                      varchar(255),
  population                bigint,
  stateId                   bigint,
  parliament                tinyint(1) default 0,
  constraint uq_constituency_1 unique (name,stateId,parliament),
  constraint pk_constituency primary key (constituency_id))
;

create table district (
  district_id               bigint auto_increment not null,
  name                      varchar(255),
  stateId                   bigint,
  constraint uq_district_1 unique (name,stateId),
  constraint pk_district primary key (district_id))
;

create table education (
  education_id              bigint auto_increment not null,
  education                 varchar(255),
  almamater                 varchar(255),
  constraint pk_education primary key (education_id))
;

create table election (
  election_id               bigint auto_increment not null,
  dateofelection            datetime,
  electionresultId          bigint,
  constraint pk_election primary key (election_id))
;

create table election_result (
  election_result_id        bigint auto_increment not null,
  constraint pk_election_result primary key (election_result_id))
;

create table family (
  family_id                 bigint auto_increment not null,
  constraint pk_family primary key (family_id))
;

create table media (
  media_id                  bigint auto_increment not null,
  name                      varchar(255),
  impact                    bigint,
  constraint uq_media_name unique (name),
  constraint pk_media primary key (media_id))
;

create table person (
  person_id                 bigint auto_increment not null,
  name                      varchar(255),
  dateofbirth               datetime,
  placeofbirth              varchar(255),
  picture                   varchar(255),
  constraint uq_person_1 unique (name,dateofbirth),
  constraint pk_person primary key (person_id))
;

create table political_party (
  political_party_id        bigint auto_increment not null,
  name                      varchar(255),
  dateofformation           datetime,
  politicianId              bigint,
  constraint uq_political_party_name unique (name),
  constraint pk_political_party primary key (political_party_id))
;

create table politician (
  politician_id             bigint auto_increment not null,
  personId                  bigint,
  constituencyId            bigint,
  politicalPartyId          bigint,
  educationId               bigint,
  familyId                  bigint,
  professionId              bigint,
  constraint pk_politician primary key (politician_id))
;

create table profession (
  profession_id             bigint auto_increment not null,
  profession                varchar(255),
  constraint uq_profession_profession unique (profession),
  constraint pk_profession primary key (profession_id))
;

create table state (
  state_id                  bigint auto_increment not null,
  name                      varchar(255),
  ut                        tinyint(1) default 0,
  constraint uq_state_name unique (name),
  constraint pk_state primary key (state_id))
;


create table constituency_district (
  constituency_constituency_id   bigint not null,
  district_district_id           bigint not null,
  constraint pk_constituency_district primary key (constituency_constituency_id, district_district_id))
;

create table election_politician (
  election_election_id           bigint not null,
  politician_politician_id       bigint not null,
  constraint pk_election_politician primary key (election_election_id, politician_politician_id))
;

create table election_result_politician (
  election_result_election_result_id bigint not null,
  politician_politician_id       bigint not null,
  constraint pk_election_result_politician primary key (election_result_election_result_id, politician_politician_id))
;

create table family_person (
  family_family_id               bigint not null,
  person_person_id               bigint not null,
  constraint pk_family_person primary key (family_family_id, person_person_id))
;

create table politician_constituency (
  politician_politician_id       bigint not null,
  constituency_constituency_id   bigint not null,
  constraint pk_politician_constituency primary key (politician_politician_id, constituency_constituency_id))
;

create table politician_election (
  politician_politician_id       bigint not null,
  election_election_id           bigint not null,
  constraint pk_politician_election primary key (politician_politician_id, election_election_id))
;

create table politician_political_party (
  politician_politician_id       bigint not null,
  political_party_political_party_id bigint not null,
  constraint pk_politician_political_party primary key (politician_politician_id, political_party_political_party_id))
;
alter table constituency add constraint fk_constituency_state_1 foreign key (stateId) references state (state_id) on delete restrict on update restrict;
create index ix_constituency_state_1 on constituency (stateId);
alter table district add constraint fk_district_state_2 foreign key (stateId) references state (state_id) on delete restrict on update restrict;
create index ix_district_state_2 on district (stateId);
alter table election add constraint fk_election_electionresult_3 foreign key (electionresultId) references election_result (election_result_id) on delete restrict on update restrict;
create index ix_election_electionresult_3 on election (electionresultId);
alter table political_party add constraint fk_political_party_partychief_4 foreign key (politicianId) references politician (politician_id) on delete restrict on update restrict;
create index ix_political_party_partychief_4 on political_party (politicianId);
alter table politician add constraint fk_politician_person_5 foreign key (personId) references person (person_id) on delete restrict on update restrict;
create index ix_politician_person_5 on politician (personId);
alter table politician add constraint fk_politician_currentconstituency_6 foreign key (constituencyId) references constituency (constituency_id) on delete restrict on update restrict;
create index ix_politician_currentconstituency_6 on politician (constituencyId);
alter table politician add constraint fk_politician_currentpoliticalparty_7 foreign key (politicalPartyId) references political_party (political_party_id) on delete restrict on update restrict;
create index ix_politician_currentpoliticalparty_7 on politician (politicalPartyId);
alter table politician add constraint fk_politician_education_8 foreign key (educationId) references education (education_id) on delete restrict on update restrict;
create index ix_politician_education_8 on politician (educationId);
alter table politician add constraint fk_politician_family_9 foreign key (familyId) references family (family_id) on delete restrict on update restrict;
create index ix_politician_family_9 on politician (familyId);
alter table politician add constraint fk_politician_profession_10 foreign key (professionId) references profession (profession_id) on delete restrict on update restrict;
create index ix_politician_profession_10 on politician (professionId);



alter table constituency_district add constraint fk_constituency_district_constituency_01 foreign key (constituency_constituency_id) references constituency (constituency_id) on delete restrict on update restrict;

alter table constituency_district add constraint fk_constituency_district_district_02 foreign key (district_district_id) references district (district_id) on delete restrict on update restrict;

alter table election_politician add constraint fk_election_politician_election_01 foreign key (election_election_id) references election (election_id) on delete restrict on update restrict;

alter table election_politician add constraint fk_election_politician_politician_02 foreign key (politician_politician_id) references politician (politician_id) on delete restrict on update restrict;

alter table election_result_politician add constraint fk_election_result_politician_election_result_01 foreign key (election_result_election_result_id) references election_result (election_result_id) on delete restrict on update restrict;

alter table election_result_politician add constraint fk_election_result_politician_politician_02 foreign key (politician_politician_id) references politician (politician_id) on delete restrict on update restrict;

alter table family_person add constraint fk_family_person_family_01 foreign key (family_family_id) references family (family_id) on delete restrict on update restrict;

alter table family_person add constraint fk_family_person_person_02 foreign key (person_person_id) references person (person_id) on delete restrict on update restrict;

alter table politician_constituency add constraint fk_politician_constituency_politician_01 foreign key (politician_politician_id) references politician (politician_id) on delete restrict on update restrict;

alter table politician_constituency add constraint fk_politician_constituency_constituency_02 foreign key (constituency_constituency_id) references constituency (constituency_id) on delete restrict on update restrict;

alter table politician_election add constraint fk_politician_election_politician_01 foreign key (politician_politician_id) references politician (politician_id) on delete restrict on update restrict;

alter table politician_election add constraint fk_politician_election_election_02 foreign key (election_election_id) references election (election_id) on delete restrict on update restrict;

alter table politician_political_party add constraint fk_politician_political_party_politician_01 foreign key (politician_politician_id) references politician (politician_id) on delete restrict on update restrict;

alter table politician_political_party add constraint fk_politician_political_party_political_party_02 foreign key (political_party_political_party_id) references political_party (political_party_id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table constituency;

drop table constituency_district;

drop table district;

drop table education;

drop table election;

drop table election_politician;

drop table election_result;

drop table election_result_politician;

drop table family;

drop table family_person;

drop table media;

drop table person;

drop table political_party;

drop table politician;

drop table politician_constituency;

drop table politician_election;

drop table politician_political_party;

drop table profession;

drop table state;

SET FOREIGN_KEY_CHECKS=1;

