-- 注意：该页面对应的前台目录为views/company_info文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


-- 主菜单
INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external)
VALUES ('178402060011301', NULL, '企业信息管理', '/company_info/companyInfoList', 'company_info/CompanyInfoList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-07-14 17:16:40', NULL, NULL, 0);

-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178402060011302', '178402060011301', '添加企业信息管理', NULL, NULL, 0, NULL, NULL, 2, 'company_info:company_info:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 17:16:40', NULL, NULL, 0, 0, '1', 0);

-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178402060011303', '178402060011301', '编辑企业信息管理', NULL, NULL, 0, NULL, NULL, 2, 'company_info:company_info:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 17:16:40', NULL, NULL, 0, 0, '1', 0);

-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178402060011304', '178402060011301', '删除企业信息管理', NULL, NULL, 0, NULL, NULL, 2, 'company_info:company_info:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 17:16:40', NULL, NULL, 0, 0, '1', 0);

-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178402060011305', '178402060011301', '批量删除企业信息管理', NULL, NULL, 0, NULL, NULL, 2, 'company_info:company_info:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 17:16:40', NULL, NULL, 0, 0, '1', 0);

-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178402060011306', '178402060011301', '导出excel_企业信息管理', NULL, NULL, 0, NULL, NULL, 2, 'company_info:company_info:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 17:16:40', NULL, NULL, 0, 0, '1', 0);

-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178402060011307', '178402060011301', '导入excel_企业信息管理', NULL, NULL, 0, NULL, NULL, 2, 'company_info:company_info:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 17:16:40', NULL, NULL, 0, 0, '1', 0);

-- 角色授权（以 admin 角色为例，role_id 可替换）
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178402060011308', 'f6817f48af4fb3af11b9e8bf182f618b', '178402060011301', NULL, '2026-07-14 17:16:40', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178402060011309', 'f6817f48af4fb3af11b9e8bf182f618b', '178402060011302', NULL, '2026-07-14 17:16:40', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178402060011310', 'f6817f48af4fb3af11b9e8bf182f618b', '178402060011303', NULL, '2026-07-14 17:16:40', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178402060011311', 'f6817f48af4fb3af11b9e8bf182f618b', '178402060011304', NULL, '2026-07-14 17:16:40', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178402060011312', 'f6817f48af4fb3af11b9e8bf182f618b', '178402060011305', NULL, '2026-07-14 17:16:40', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178402060011313', 'f6817f48af4fb3af11b9e8bf182f618b', '178402060011306', NULL, '2026-07-14 17:16:40', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178402060011314', 'f6817f48af4fb3af11b9e8bf182f618b', '178402060011307', NULL, '2026-07-14 17:16:40', '127.0.0.1');