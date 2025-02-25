package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static PorderDaoImpl porderdaoimpl=new PorderDaoImpl();

	@Override
	public void addPorder(Porder porder) {
		
		if(porder.getDesk()>=0 && porder.getGamingChair()>=0 && porder.getWardrobe()>=0) 
		{
			porderdaoimpl.add(porder);
		}
				
	}

	@Override
	public String AllPorder() {
		List<Porder> l=porderdaoimpl.selectAll();
		String show="";
		
		for(Porder p:l)
		{
			int sum=p.getDesk()*1999
					+p.getGamingChair()*4999
					+p.getWardrobe()*5799;
			
			show=show+"訂單:"+p.getId()+
					"\t客戶:"+p.getName()+
					"\t襯衫:"+p.getDesk()+
					"\t長褲:"+p.getGamingChair()+
					"\t球鞋:"+p.getWardrobe()+
					"\t金額:"+sum+"元\n";
		}
		
		return show;
	}

	@Override
	public List<Porder> findAllPorder() {
		
		return porderdaoimpl.selectAll();
		
	}

	@Override
	public Porder findById(int id) {
		Porder porder=null;
		if(id>0)
		{
			List<Porder> l=porderdaoimpl.selectById(id);
			if(l.size()>0)
			{
				porder=l.get(0);
						
			}
		}
																		
		return porder;
	}

	@Override
	public void updatePorder(String name, int id) {
		Porder p=findById(id);
		p.setName(name);
		
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(int desk, int gamingChair, int wardrobe, int id) {
		Porder p=findById(id);
		p.setDesk(desk);
		p.setGamingChair(gamingChair);
		p.setWardrobe(wardrobe);
		
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(Porder porder) {
		Porder p=findById(porder.getId());
		
	}

	@Override
	public void deletePorderById(int id) {
		if(id>0) {
			porderdaoimpl.delete(id);
		}
		
	}

	@Override
	public String findUsername(String username) {
		//return porderdaoimpl.selectByUsername(username);
		List<Porder> l=porderdaoimpl.selectByUsername(username);
		String show="";
		
		for(Porder p:l)
		{
			int sum=p.getDesk()*1999
					+p.getGamingChair()*4999
					+p.getWardrobe()*5799;
			
			show=show+"訂單:"+p.getId()+
					"\t客戶:"+p.getName()+
					"\t書桌:"+p.getDesk()+
					"\t電競椅:"+p.getGamingChair()+
					"\t衣櫃:"+p.getWardrobe()+
					"\t金額:"+sum+"元\n";
		}
		
		return show;
	}

}
