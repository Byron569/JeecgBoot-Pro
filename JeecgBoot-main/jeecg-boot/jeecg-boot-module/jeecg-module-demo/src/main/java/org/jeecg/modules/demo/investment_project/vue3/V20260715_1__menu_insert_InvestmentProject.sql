-- 注意：该页面对应的前台目录为views/investment_project文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


-- 主菜单
INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external)
VALUES ('178408104048901', NULL, '招商项目管理', '/investment_project/investmentProjectList', 'investment_project/InvestmentProjectList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-07-15 10:04:00', NULL, NULL, 0);

-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178408104048902', '178408104048901', '添加招商项目管理', NULL, NULL, 0, NULL, NULL, 2, 'investment_project:investment_project:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-15 10:04:00', NULL, NULL, 0, 0, '1', 0);

-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178408104048903', '178408104048901', '编辑招商项目管理', NULL, NULL, 0, NULL, NULL, 2, 'investment_project:investment_project:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-15 10:04:00', NULL, NULL, 0, 0, '1', 0);

-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178408104048904', '178408104048901', '删除招商项目管理', NULL, NULL, 0, NULL, NULL, 2, 'investment_project:investment_project:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-15 10:04:00', NULL, NULL, 0, 0, '1', 0);

-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178408104048905', '178408104048901', '批量删除招商项目管理', NULL, NULL, 0, NULL, NULL, 2, 'investment_project:investment_project:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-15 10:04:00', NULL, NULL, 0, 0, '1', 0);

-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178408104048906', '178408104048901', '导出excel_招商项目管理', NULL, NULL, 0, NULL, NULL, 2, 'investment_project:investment_project:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-15 10:04:00', NULL, NULL, 0, 0, '1', 0);

-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178408104048907', '178408104048901', '导入excel_招商项目管理', NULL, NULL, 0, NULL, NULL, 2, 'investment_project:investment_project:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-15 10:04:00', NULL, NULL, 0, 0, '1', 0);

-- 角色授权（以 admin 角色为例，role_id 可替换）
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178408104048908', 'f6817f48af4fb3af11b9e8bf182f618b', '178408104048901', NULL, '2026-07-15 10:04:00', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178408104048909', 'f6817f48af4fb3af11b9e8bf182f618b', '178408104048902', NULL, '2026-07-15 10:04:00', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178408104048910', 'f6817f48af4fb3af11b9e8bf182f618b', '178408104048903', NULL, '2026-07-15 10:04:00', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178408104048911', 'f6817f48af4fb3af11b9e8bf182f618b', '178408104048904', NULL, '2026-07-15 10:04:00', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178408104048912', 'f6817f48af4fb3af11b9e8bf182f618b', '178408104048905', NULL, '2026-07-15 10:04:00', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178408104048913', 'f6817f48af4fb3af11b9e8bf182f618b', '178408104048906', NULL, '2026-07-15 10:04:00', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178408104048914', 'f6817f48af4fb3af11b9e8bf182f618b', '178408104048907', NULL, '2026-07-15 10:04:00', '127.0.0.1');