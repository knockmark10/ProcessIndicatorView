

Process Indicator View
====================  
  
[![](https://jitpack.io/v/knockmark10/ProcessIndicatorView.svg)](https://jitpack.io/#knockmark10/ProcessIndicatorView)
  
### Description  
  
Process Indicator View is a very customizable component for displaying a process indicator on what's going on.
  
### Integration  
  
**1)** Add it in your root ``build.gradle`` at the end of repositories:
  
```groovy  
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```  

**2)** Add the dependency
```groovy  
dependencies {
          implementation 'com.github.knockmark10:ProcessIndicatorView:1.0.0-beta1'
	}
```  
  
**3)** Add ``FrameLayout`` to your layout XML file. Content is automatically displayed centered within free space.  
  
```xml  
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"  
  xmlns:tools="http://schemas.android.com/tools"  
  android:layout_width="match_parent"  
  android:layout_height="match_parent"  
  tools:context=".MainActivity">  
  
 <FrameLayout  
  android:id="@+id/process_view"  
  android:layout_width="0dp"  
  android:layout_height="0dp"  
  app:layout_constraintBottom_toBottomOf="parent"  
  app:layout_constraintLeft_toLeftOf="parent"  
  app:layout_constraintRight_toRightOf="parent"  
  app:layout_constraintTop_toTopOf="parent" /> 
  
</android.support.constraint.ConstraintLayout> 
```  
  
**4)** Initialize the component. Call *inner class* ``Builder`` to customize it.
  
```java  
public class MainActivity extends AppCompatActivity {  
	
	@Override
	public void onCreate(Bundle savedInstanceState){
	ProcessIndicatorView view = new ProcessIndicatorView.Builder()
	    .setTrackColor(R.color.colorPrimaryDark)
        .setSelectedProcessDrawable(R.drawable.round_test)
        .setUnselectedProcessDrawable(R.drawable.round_test_normal)
        .setFistStageIcon(R.drawable.ic_search)
        .setSecondStageIcon(R.drawable.ic_search)
        .setThirdStageIcon(R.drawable.ic_search)
        .setFourthStageIcon(R.drawable.ic_search)
        .setFiftsStageIcon(R.drawable.ic_search)
        .create(R.id.main_container, supportFragmentManager)
	}
}
```  

**5)** Change the process by calling ``nextStage`` or ``previousStage``. 
```java  
public class MainActivity extends AppCompatActivity {  
	@Override
	public void onCreate(Bundle savedInstanceState){
	ProcessIndicatorView view = new ProcessIndicatorView.Builder()
		...
	//Go to next stage 
	view.nextStage();
	//Go to previous stage
	view.previousStage();
	}
}
```  

**NOTE:  It won't allow you to go further if you want to go to previous stage being in the first stage, nor to go to next stage if you're in the last stage possible.** 

  
**6)** That's it! It requires no more to set up. The animations will be handled automatically. Just enjoy. 
  
![Demo](https://i.imgur.com/DNtNHyF.gif)
  
### Restriction
 
 As for now, the library is not dinamyc in terms of number of items displayed on the bar. It's limited to 5 items.
  
### License  
  
```  
The MIT License (MIT)  
  
Copyright (c) 2019 Marco Chavez
  
Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:  
  
The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.  
  
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  
SOFTWARE.  
```
