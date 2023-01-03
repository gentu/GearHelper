package com.max51v.gearhelper.main;
    
import android.util.Log;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

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
      			
      			}
 //############################################################################################
				if("com.samsung.android.app.watchmanager".equals(lpparam.packageName)) {

  /*    XposedHelpers.findAndHookMethod("com.samsung.android.app.watchmanager.util.HostManagerUtils", lpparam.classLoader, "isSamsungDevice", new XC_MethodReplacement() {
						@Override
						protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
								Log.i("GearHelper", "Hooked method9 called - " + param.method.getName());
								boolean flag;
								flag = true;
								return flag;
						}
      			});*/

      XposedHelpers.findAndHookMethod("com.samsung.android.app.watchmanager.util.UHMDownloadManager", lpparam.classLoader, "getDownloadCheckServerURL", String.class, new XC_MethodHook() {
 						@Override
						protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
								String fixed = (String) param.getResult().toString().replaceAll("&deviceId=(.+?)&", "&deviceId=SM-N9005&").replaceAll("&sdkVer=(.+?)&", "&sdkVer=21&");
								Log.i("GearHelper", "Hooked method10 called - " + fixed);
								param.setResult(fixed.toString());
								return;
						}

      			});

				}
				
		}
}
