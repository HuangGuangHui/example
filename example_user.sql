---------------------------------------------------------------
-- Export file for user EXAMPLE_USER@172.16.1.25:1521/MYORCL --
-- Created by it023 on 2017-08-07, 09:11:37.37 ----------------
---------------------------------------------------------------

set define off
spool example_user.log

prompt
prompt Creating table LC_STACK
prompt =======================
prompt
create table EXAMPLE_USER.LC_STACK
(
  key   VARCHAR2(20) not null,
  value CLOB
)
tablespace EXAMPLE_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table EXAMPLE_USER.LC_STACK
  is '这个是保存现场情况的表，在关闭服务时要先把只存入该表，重新启动时从该表取值，并将该表清空';
alter table EXAMPLE_USER.LC_STACK
  add constraint LCS_PK primary key (KEY)
  using index 
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255;

prompt
prompt Creating table USERS
prompt ====================
prompt
create table EXAMPLE_USER.USERS
(
  id           NUMBER not null,
  usernumber   VARCHAR2(20),
  userpassword VARCHAR2(20),
  name         VARCHAR2(20),
  r_id         NUMBER
)
tablespace EXAMPLE_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column EXAMPLE_USER.USERS.usernumber
  is '账号';
comment on column EXAMPLE_USER.USERS.userpassword
  is '密码';
comment on column EXAMPLE_USER.USERS.name
  is '名字';
comment on column EXAMPLE_USER.USERS.r_id
  is '角色id';
create unique index EXAMPLE_USER.U_NUM on EXAMPLE_USER.USERS (USERNUMBER)
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table EXAMPLE_USER.USERS
  add constraint U_PK primary key (ID)
  using index 
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table LC_TOKEN
prompt =======================
prompt
create table EXAMPLE_USER.LC_TOKEN
(
  token        VARCHAR2(255) not null,
  u_id         NUMBER not null,
  invalid_time TIMESTAMP(6) not null
)
tablespace EXAMPLE_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column EXAMPLE_USER.LC_TOKEN.token
  is '授权码';
comment on column EXAMPLE_USER.LC_TOKEN.u_id
  is '关联用户表id，我这里暂时没做，但如果做就做级联删除的主外键约束';
comment on column EXAMPLE_USER.LC_TOKEN.invalid_time
  is '失效时间';
create unique index EXAMPLE_USER.LCT_UID on EXAMPLE_USER.LC_TOKEN (U_ID)
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table EXAMPLE_USER.LC_TOKEN
  add constraint LCT_PK primary key (TOKEN)
  using index 
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table EXAMPLE_USER.LC_TOKEN
  add constraint LCT_FK foreign key (U_ID)
  references EXAMPLE_USER.USERS (ID) on delete cascade;

prompt
prompt Creating table PERMISSION
prompt =========================
prompt
create table EXAMPLE_USER.PERMISSION
(
  id          NUMBER not null,
  url         VARCHAR2(100) not null,
  method      VARCHAR2(10) not null,
  name        VARCHAR2(40) not null,
  describtion VARCHAR2(4000),
  flag        VARCHAR2(40) not null
)
tablespace EXAMPLE_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column EXAMPLE_USER.PERMISSION.id
  is '不自增，是为了id有规律';
comment on column EXAMPLE_USER.PERMISSION.name
  is '名字';
comment on column EXAMPLE_USER.PERMISSION.describtion
  is '描述';
comment on column EXAMPLE_USER.PERMISSION.flag
  is '用于权限分类，flag相同的为一组';
create index EXAMPLE_USER.PER_FALG on EXAMPLE_USER.PERMISSION (FLAG)
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index EXAMPLE_USER.PER_METHOD on EXAMPLE_USER.PERMISSION (METHOD)
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index EXAMPLE_USER.PER_U_M on EXAMPLE_USER.PERMISSION (URL, METHOD)
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table EXAMPLE_USER.PERMISSION
  add constraint PER_PK primary key (ID)
  using index 
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ROLE
prompt ===================
prompt
create table EXAMPLE_USER.ROLE
(
  id          NUMBER not null,
  name        VARCHAR2(40),
  describtion VARCHAR2(255),
  pers        VARCHAR2(4000)
)
tablespace EXAMPLE_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column EXAMPLE_USER.ROLE.name
  is '角色名字';
comment on column EXAMPLE_USER.ROLE.describtion
  is '角色描述';
comment on column EXAMPLE_USER.ROLE.pers
  is '权限序列';
alter table EXAMPLE_USER.ROLE
  add constraint R_PK primary key (ID)
  using index 
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TIMELINE
prompt =======================
prompt
create table EXAMPLE_USER.TIMELINE
(
  id          NUMBER not null,
  p_id        NUMBER not null,
  u_id        NUMBER not null,
  create_time TIMESTAMP(6) not null,
  deta_info   VARCHAR2(4000)
)
tablespace EXAMPLE_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column EXAMPLE_USER.TIMELINE.deta_info
  is '详细参数，json格式';
alter table EXAMPLE_USER.TIMELINE
  add constraint TL_PK primary key (ID)
  using index 
  tablespace EXAMPLE_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table EXAMPLE_USER.TIMELINE
  add constraint TL_FK_P foreign key (P_ID)
  references EXAMPLE_USER.PERMISSION (ID) on delete cascade;
alter table EXAMPLE_USER.TIMELINE
  add constraint TL_FK_U foreign key (U_ID)
  references EXAMPLE_USER.USERS (ID) on delete cascade;

prompt
prompt Creating sequence R_AUTO
prompt ========================
prompt
create sequence EXAMPLE_USER.R_AUTO
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence TL_AUTO
prompt =========================
prompt
create sequence EXAMPLE_USER.TL_AUTO
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence U_AUTO
prompt ========================
prompt
create sequence EXAMPLE_USER.U_AUTO
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating trigger R_ID_AUTO
prompt ==========================
prompt
create or replace trigger example_user.r_id_auto
  before insert
  on ROLE 
  for each row
declare
  -- local variables here
begin
if :new.id is null 
then
    select r_auto.nextval into :new.id from dual;
end if;
end r_id_auto;
/

prompt
prompt Creating trigger TL_ID_AUTO
prompt ===========================
prompt
create or replace trigger example_user.tl_id_auto
  before insert
  on TIMELINE 
  for each row
declare
  -- local variables here
begin
if :new.id is null 
then
    select tl_auto.nextval into :new.id from dual;
end if;
select  SYSDATE() into :new.create_time from dual;
end tl_id_auto;
/

prompt
prompt Creating trigger U_ID_AUTO
prompt ==========================
prompt
create or replace trigger example_user.u_id_auto
  before insert
  on USERS 
  for each row
declare
  -- local variables here
begin
if :new.id is null 
then
    select u_auto.nextval into :new.id from dual;
end if;
end u_id_auto;
/


spool off
