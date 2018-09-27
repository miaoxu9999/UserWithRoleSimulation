package ServiceResponsitory;

import java.util.ArrayList;
import java.util.List;
import Service.*;;


public class ServiceResponsitory {
	private static List<Service> list = new ArrayList<>();
	public static void add(Service service) {
		list.add(service);
	}
	public static List<Service> getList() {
		return list;
	}
	public static void setList(List<Service> list) {
		ServiceResponsitory.list = list;
	}
}
