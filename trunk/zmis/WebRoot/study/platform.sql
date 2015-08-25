---标量函数		
		if exists(select * from sys.objects where object_id=OBJECT_ID('fn_finduser') and type='FN')
			drop function fn_finduser
		go
		create function fn_finduser(@name varchar(200), @pwd varchar(200))
		returns int
		as
		begin
		return (select COUNT(1) from SYS_USER where user_name=@name and user_pwd=@pwd)
		end
		go
		select dbo.fn_finduser('test2', '0390cc43663c50b84daa4f8ec97110c13f867175') as cou
		---table function
--表值函数
		go
		if exists(select * from sys.objects where object_id=OBJECT_ID('fn_table_function') and type='FN')
			drop function fn_table_function
		go
		create function fn_table_function(@name varchar(200), @pwd varchar(200))
		returns table
		as
			return(select * from SYS_USER where user_name=@name and user_pwd=@pwd)
		go
		---
		select * from dbo.fn_table_function('test2', '0390cc43663c50b84daa4f8ec97110c13f867175')
		go
--存储过程(create proc)
		if exists (select  * from sys.objects where object_id=OBJECT_ID('pr_finduser') and type='P')
			drop procedure pr_finduser
		go
		create procedure pr_finduser(@name varchar(200), @pwd varchar(200))
		as 
		begin
			select * from SYS_USER where user_name=@name and user_pwd=@pwd
		end
		go
		exec pr_finduser 'test2', '0390cc43663c50b84daa4f8ec97110c13f867175'
		
--存储过程(2)  实际业务   用户登录
		if exists (select * from sys.objects where object_id=OBJECT_ID('p_finduser3') and type='P')
			drop proc p_finduser3
		go
		create proc p_finduser3
		@name varchar(200),
		@pwd varchar(200),
		@out int out
		as
			begin
				if exists(select * from SYS_USER where user_name=@name)
					begin
						if exists(select * from SYS_USER where user_name=@name and user_pwd=@pwd)
							set @out = 1  --登录成功
						else 
							set @out = 0 --密码不正确
					end
				else 
				set @out=-1  -- 没有这个用户
			end
		--exec 存储过程
		go
		declare @out int 
		exec p_finduser3 'test2', '0390cc43663c50b84daa4f8ec97110c13f867175', @out output
		select @out as cou
--触发器
		if exists(select * from sys.objects where object_id=OBJECT_ID('tr_testuser'))
			drop trigger tr_testuser
		go
		create trigger tr_testuser
		on SYS_USER
		for insert, update, delete
		as
		begin
			select COUNT(1) from SYS_USER 
		end
		go
		--c
		delete from SYS_USER where user_id=2
--游标的使用
		go
		
		declare @name varchar(200)
		declare @pwd varchar(200)
		declare cu_finduser cursor
		For
			select user_name, user_pwd from SYS_USER 
		open cu_finduser
		select @@CURSOR_ROWS as '当前记录位置'
		fetch next from cu_finduser into @name, @pwd
		while @@FETCH_STATUS=0
		begin
			print '-----------------------------------------'
			print 'name:'+@name+' ,'+@pwd
			fetch next from cu_finduser into @name, @pwd
		end
		close cu_finduser
		deallocate cu_finduser
--动态SQL
		go
		declare @sql varchar(200)='select * from SYS_USER';
		exec(@sql) 
--



go
select * from SYS_MENU
--SQL Server2008 新特性--select * from SYS_MENU
declare @parent_hid hierarchyid, @max_hid hierarchyid, @new_hid hierarchyid
select @parent_hid=hid from SYS_MENU where menu_key='1'
select * from SYS_MENU where hid.IsDescendantOf(@parent_hid)=1  ---获取在menu_key所有的子节点
go
declare @parent_hid hierarchyid, @max_hid hierarchyid
select @parent_hid = hid from SYS_MENU where menu_key='11000'
select * from SYS_MENU where hid.IsDescendantOf(@parent_hid)=1 --- 参数为父节点  得到所有的子节点
---
go
declare @parent_hid hierarchyid, @max_hid hierarchyid
select @parent_hid = hid from SYS_MENU where menu_key='11000'
select * from SYS_MENU where @parent_hid = hid.GetAncestor(1)  --得到第一代子孙的节点   
go
declare @parent_hid hierarchyid, @max_hid hierarchyid, @new_hid hierarchyid
select @parent_hid = hid from SYS_MENU where menu_key='11000'
select @max_hid=MAX(hid) from SYS_MENU where @parent_hid = hid.GetAncestor(1)
select @new_hid = @parent_hid.GetDescendant(@max_hid, null)
select @new_hid
--GetAncestor取得某一个级别的祖先
--GetDescendant ：取得某一个级别的子代 