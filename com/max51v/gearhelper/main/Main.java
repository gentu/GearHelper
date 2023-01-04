package com.max51v.gearhelper.main;
    
import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import java.net.URL;

public class Main implements IXposedHookLoadPackage{
		@Override
		public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
				if("com.samsung.android.hostmanager".equals(lpparam.packageName)) {
				
      XposedHelpers.findAndHookMethod("com.samsung.android.hostmanager.callforward.MultiSimCallForwardManager", lpparam.classLoader, "getPhoneNumberSim2", new XC_MethodReplacement() {
      		@Override
         protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
         		Log.i("GearHelper", "Hooked method1 called - " + param.method.getName());
            String s;
            s = "0";
            return s;
                    	}
                });
                
      XposedHelpers.findAndHookMethod("com.samsung.android.hostmanager.callforward.MultiSimCallForwardManager", lpparam.classLoader, "isDualModel", new XC_MethodReplacement() {
    				@Override
    				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
    						Log.i("GearHelper", "Hooked method2 called - " + param.method.getName());
    						boolean flag;
    						flag = false;
    						return flag;
                  		}
              });


      XposedHelpers.findAndHookMethod("com.samsung.android.hostmanager.callforward.MultiSimCallForwardManager", lpparam.classLoader, "getPhoneTypeSim2", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method3 called - " + param.method.getName());
								String s;
								s = "0";
								return s;
						}
      			}); 

      XposedHelpers.findAndHookMethod("com.samsung.android.hostmanager.utils.CommonUtils", lpparam.classLoader, "isSamsungDevice", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method4 called - " + param.method.getName());
								boolean flag;
								flag = false;
								return flag;
						}
      			}); 

      XposedHelpers.findAndHookMethod("com.samsung.android.hostmanager.service.HMSamsungAppStoreService", lpparam.classLoader, "checkSignatureForBind", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method5 called - " + param.method.getName());
								boolean flag;
								flag = true;
								return flag;
						}
      			});

				}
//############################################################################################				
				
				if("com.sec.android.app.samsungapps".equals(lpparam.packageName)) {
				
      XposedHelpers.findAndHookMethod("com.samsung.android.sdk.SsdkVendorCheck", lpparam.classLoader, "isSamsungDevice", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method6 called - " + param.method.getName());
								boolean flag;
								flag = true;
								return flag;
						}
      			});
      
      XposedHelpers.findAndHookMethod("com.sec.android.app.samsungapps.vlibrary.concreteloader.ConcreteDeviceInfoLoader", lpparam.classLoader, "getOpenApiVersion", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method7 called - " + param.method.getName());
            String s;
            s = "21";
            return s;
						}
      			});
      			
      XposedHelpers.findAndHookMethod("com.sec.android.app.samsungapps.vlibrary.concreteloader.ConcreteDeviceInfoLoader", lpparam.classLoader, "getModelName", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method8 called - " + param.method.getName());
            String s;
            s = "SM-N9005";
            return s;
						}
      			});
      			
      XposedHelpers.findAndHookMethod("com.sec.android.wallet.confirm.http.CheckWalletAvaliable", lpparam.classLoader, "a", new XC_MethodHook() {
						@Override
						protected void afterHookedMethod(MethodHookParam param) throws Throwable {
								String fakeresult = param.getResult().toString().replaceAll("&deviceId=(.+?)&", "&deviceId=SM-N9005&").replaceAll("&openApi=(.+?)&", "&openApi=21&");
								Log.i("GearHelper", "Hooked method8.5 called - " + fakeresult);
            param.setResult(fakeresult);
						}
      			});      			
      			
      			}
 //############################################################################################
				if("com.samsung.android.app.watchmanager".equals(lpparam.packageName)) {

      XposedHelpers.findAndHookMethod("com.samsung.android.app.watchmanager.util.HostManagerUtils", lpparam.classLoader, "isSamsungDevice", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method9 called - " + param.method.getName());
								boolean flag;
								flag = true;
								return flag;
						}
      			});

      XposedHelpers.findAndHookMethod("com.samsung.android.app.watchmanager.util.UHMDownloadManager", lpparam.classLoader, "getDownloadCheckServerURL", String.class, new XC_MethodHook() {
 						@Override
						protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
								String fakeresult = param.getResult().toString().replaceAll("&deviceId=(.+?)&", "&deviceId=SM-N9005&").replaceAll("&sdkVer=(.+?)&", "&sdkVer=21&");
								Log.i("GearHelper", "Hooked method10 called - " + fakeresult);
								param.setResult(fakeresult);
						}
      			});

      XposedHelpers.findAndHookMethod("com.samsung.android.app.watchmanager.util.UHMDownloadManager", lpparam.classLoader, "getUpdateCheckServerURL", String.class, new XC_MethodHook() {
 						@Override
						protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
								String fakeresult = param.getResult().toString().replaceAll("&deviceId=(.+?)&", "&deviceId=SM-N9005&").replaceAll("&openApi=(.+?)&", "&openApi=21&");
								Log.i("GearHelper", "Hooked method11 called - " + fakeresult);
								param.setResult(fakeresult);
						}
      			});

      XposedHelpers.findAndHookMethod("com.samsung.android.app.watchmanager.update.UpdateDownloadThread", lpparam.classLoader, "checkUpdate", URL.class, new XC_MethodHook() {
 						@Override
						protected void beforeHookedMethod(final MethodHookParam param) throws Throwable {
								String fakeargs = param.args[0].toString().replaceAll("&deviceId=(.+?)&", "&deviceId=SM-N9005&").replaceAll("&openApi=(.+?)&", "&openApi=21&");
								Log.i("GearHelper", "Hooked method12 called - " + fakeargs);
								param.args[0] = new URL(fakeargs);
						}
      			});

      XposedHelpers.findAndHookMethod("com.samsung.android.app.watchmanager.update.UpdateDownloadThread", lpparam.classLoader, "checkDownload", URL.class, new XC_MethodHook() {
 						@Override
						protected void beforeHookedMethod(final MethodHookParam param) throws Throwable {
								String fakeargs = param.args[0].toString().replaceAll("&deviceId=(.+?)&", "&deviceId=SM-N9005&").replaceAll("&openApi=(.+?)&", "&openApi=21&");
								Log.i("GearHelper", "Hooked method13 called - " + fakeargs);
								param.args[0] = new URL(fakeargs);
						}
      			});
   
				}
 //############################################################################################
				if("com.samsung.android.gear2plugin".equals(lpparam.packageName)) {
      XposedHelpers.findAndHookMethod("com.samsung.android.gear2plugin.util.HostManagerUtils", lpparam.classLoader, "isSamsungDevice", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method14 called - " + param.method.getName());
								boolean flag;
								flag = true;
								return flag;
						}
      			});
      			
      XposedHelpers.findAndHookMethod("com.samsung.android.gear2plugin.activity.stub.HMStubCommon", lpparam.classLoader, "getModelName", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method15 called - " + param.method.getName());
            String s;
            s = "SM-N9005";
            return s;
						}
      			}); 
 
				}
		}
}
