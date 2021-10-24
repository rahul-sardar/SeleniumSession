package ListeneresDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		//List<IMethodInstance> methods will contain all the methods Testng going to execute in our case test1(), test2(), test3()
		
		//In this program we are to disable few test cases at run time
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		
		Map<String, String> test1 =new HashMap<String, String>();
		test1.put("name", "test1");
		test1.put("count", "5");
		
		Map<String, String> test2 =new HashMap<String, String>();
		test2.put("name", "test2");
		test2.put("count", "2");
		
		List<Map<String, String>> list = new ArrayList<>();
		list.add(test1);
		list.add(test2);
		
		for(int i=0; i<methods.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))) {
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
					result.add(methods.get(i));
				}
			}
		}
		
		return result;
	}

	//now after creating this class to use it add in in .xml as a listener tag
	//priority enabled adding descrition can be done during runtime using this above concept
	
}
