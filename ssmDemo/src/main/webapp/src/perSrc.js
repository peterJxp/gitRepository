var url = "";

function openUserAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle", "添加用户信息");
    url = "/perTest/add";
}

function openUserModifyDialog() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
    $("#fm").form("load", row);
    url = "/perTest/add?id=" + row.id;
}

function saveUser() {
    $("#fm").form("submit", {
        url: url,
        success: function (result) {
            var result = eval('(' + result + ')');
            if (result.success) {
                $.messager.alert("系统提示", "保存成功！");
                // resetValue();
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
            } else {
                $.messager.alert("系统提示", "保存失败！");
                return;
            }
        }
    });
}

// function resetValue() {
//     $("#name").val()
//     $("#userName").val("");
//     $("#password").val("");
//     $("#trueName").val("");
//     $("#email").val("");
//     $("#phone").val("");
//     $("#roleName").combobox("setValue", "");
// }

function closeUserDialog() {
    $("#dlg").dialog("close");
    // resetValue();
}

function deleteUser() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据！");
        return;
    }
    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    $.messager.confirm("系统提示", "您确定要删除这<font color=red>"
        + selectedRows.length + "</font>条数据吗？", function (r) {
        if (r) {
            $.post("/perTest/deletePer", {
                ids: ids
            }, function (result) {
                if (result.success) {
                    $.messager.alert("系统提示", "数据已成功删除！");
                    $("#dg").datagrid("reload");
                } else {
                    $.messager.alert("系统提示", "数据删除失败，请联系系统管理员！");
                }
            }, "json");
        }
    });
}

function exportExecl() {
    var tableName=$("#tableName").val();
    var selectedRows = $("#dg").datagrid("getSelections");
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要导出的数据！");
        return;
    }

    var strIds = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids = strIds.join(",");
    window.location.href = "/ExportExecl?ids=" + ids+"&tableName="+tableName;
}
