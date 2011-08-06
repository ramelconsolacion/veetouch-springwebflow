
function createRoundRequest(xhr, status, args) {  

		if(args.validationFailed || !args.noDuplicate) {  
			saveFailedDialog.show();
		} else {  
			createRoundDialog.hide();
			saveCompleteDialog.show();  
		}  
}  
function createWbs(xhr, status, args){
	if(args.validationFailed || args.wrongInput) {  
		saveFailedDialog.show();
	} else {  
		newWbsDialog.hide();
		saveCompleteDialog.show();  
	}  
}
function editWbs(xhr, status, args){
	if(args.validationFailed || args.wrongInput) {  
		saveFailedDialog.show();
	} else {  
		editWbsDialog.hide();
		saveCompleteDialog.show();  
	}  
}
function resultStatus(xhr, status, args,widgetVar){
	if(args.validationFailed || args.wrongInput) {  
		saveFailedDialog.show();
	} else {  
		widgetVar.hide();
		//saveCompleteDialog.show();  
	}  
}

function resultStatusTwoDialog(xhr, status, args,widgetVar,widgetVar2){
	if(args.validationFailed || args.wrongInput) {  
		saveFailedDialog.show();
	} else {  
		widgetVar.hide();
		widgetVar2.hide();
		//saveCompleteDialog.show();  
	}  
}
function initEditor(widgetVar){
	widgetVar.init();
}
