

//in WebView class 
public void loadUrl(@NonNull String url)  {
    	
    	// calling the model and it's will return true = safe => DON'T show the alert , false = Dangerous => show the alert
    	//if (!url.equals("")){
	try{
    	if (UrlDetectorModel.isUrlSafe(url)){
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(getContext() );
    	builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("Dangerous  URL");
	builder.setMessage("This URL contains malware, do you want to continue?");
       	builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
		checkThread();
        	mProvider.loadUrl(url);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
               mProvider.loadUrl("");
              
            }
        });
        builder.create().show();
        }
        }catch(Exception e){
        }

    }
    
// in activity class 
        @Override
    public void startActivity(Intent intent) {

    	String action = intent.getAction();
    	//"android.intent.action.VIEW".equals(action)
    	//action.equals( "android.intent.action.VIEW")
    	try{
    	if (UrlDetectorModel.isUrlSafe(url)){
    	if ("android.intent.action.VIEW".equals(action) ) { 
    	AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
	builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("Dangerous  URL");
	builder.setMessage("This URL contains malware, do you want to continue?");
       	builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startActivity(intent, null);
                
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.create().show();
        }
        }
        }catch(Exception e){
        }
        else 
       		this.startActivity(intent, null);
    }
