-- 注意：该页面对应的前台目录为views/land_parcel文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


-- 主菜单
INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external)
VALUES ('178399742524801', NULL, '地块信息表', '/land_parcel/landParcelList', 'land_parcel/LandParcelList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-07-14 10:50:25', NULL, NULL, 0);

-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178399742524802', '178399742524801', '添加地块信息表', NULL, NULL, 0, NULL, NULL, 2, 'land_parcel:land_parcel:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 10:50:25', NULL, NULL, 0, 0, '1', 0);

-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178399742524803', '178399742524801', '编辑地块信息表', NULL, NULL, 0, NULL, NULL, 2, 'land_parcel:land_parcel:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 10:50:25', NULL, NULL, 0, 0, '1', 0);

-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178399742524804', '178399742524801', '删除地块信息表', NULL, NULL, 0, NULL, NULL, 2, 'land_parcel:land_parcel:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 10:50:25', NULL, NULL, 0, 0, '1', 0);

-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178399742524805', '178399742524801', '批量删除地块信息表', NULL, NULL, 0, NULL, NULL, 2, 'land_parcel:land_parcel:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 10:50:25', NULL, NULL, 0, 0, '1', 0);

-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178399742524806', '178399742524801', '导出excel_地块信息表', NULL, NULL, 0, NULL, NULL, 2, 'land_parcel:land_parcel:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 10:50:25', NULL, NULL, 0, 0, '1', 0);

-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178399742524807', '178399742524801', '导入excel_地块信息表', NULL, NULL, 0, NULL, NULL, 2, 'land_parcel:land_parcel:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-07-14 10:50:25', NULL, NULL, 0, 0, '1', 0);

-- 角色授权（以 admin 角色为例，role_id 可替换）
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178399742524908', 'f6817f48af4fb3af11b9e8bf182f618b', '178399742524801', NULL, '2026-07-14 10:50:25', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178399742524909', 'f6817f48af4fb3af11b9e8bf182f618b', '178399742524802', NULL, '2026-07-14 10:50:25', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178399742524910', 'f6817f48af4fb3af11b9e8bf182f618b', '178399742524803', NULL, '2026-07-14 10:50:25', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178399742524911', 'f6817f48af4fb3af11b9e8bf182f618b', '178399742524804', NULL, '2026-07-14 10:50:25', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178399742524912', 'f6817f48af4fb3af11b9e8bf182f618b', '178399742524805', NULL, '2026-07-14 10:50:25', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178399742524913', 'f6817f48af4fb3af11b9e8bf182f618b', '178399742524806', NULL, '2026-07-14 10:50:25', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178399742524914', 'f6817f48af4fb3af11b9e8bf182f618b', '178399742524807', NULL, '2026-07-14 10:50:25', '127.0.0.1');