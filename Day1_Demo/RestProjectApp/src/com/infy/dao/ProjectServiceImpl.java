package com.infy.dao;
import java.util.ArrayList;
import java.util.List;
import com.infy.model.Project;
public class ProjectServiceImpl implements ProjectService{
  static List<Project> plist=new ArrayList<Project>();
    static
    {
    	plist.add(new Project("101", "Apple", 2));
    	plist.add(new Project("102", "Oracle", 3));
    	plist.add(new Project("103", "Samsung", 2));
    	plist.add(new Project("104", "NetAPP", 3));
    }
	@Override
	public List<Project> getXml() {
		// TODO Auto-generated method stub
		return plist;
	}

	@Override
	public List<Project> getJson() {
		// TODO Auto-generated method stub
		return plist;
	}

	@Override
	public void addProject(Project proj) {
		plist.add(proj);
		
	}

	@Override
	public void updateProject(Project upproj) {
		String p=upproj.getId();
		for (int i=0;i<plist.size();i++)
		{
			if(plist.get(i).getId().equalsIgnoreCase(p))
			{
				plist.get(i).setName(upproj.getName());
				plist.get(i).setDuration(upproj.getDuration());
			}
		}
	}

	@Override
	public void deletProject(String id) {
		for(int i=0;i<plist.size();i++)
		{
			if(plist.get(i).getId().equalsIgnoreCase(id))
			{
				plist.remove(i);
			}
		}
		
	}

}
