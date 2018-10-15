package com.newcodor.mybatisdemos.entity;

import java.util.Arrays;
import java.util.List;

public class QueryVo {
		
		private User user;
		private Integer id;
		private Integer[] ids;
		private List<Integer>  idsList;
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer[] getIds() {
			return ids;
		}
		public void setIds(Integer[] ids) {
			this.ids = ids;
		}
		public List<Integer> getIdsList() {
			return idsList;
		}
		public void setIdsList(List<Integer> idsList) {
			this.idsList = idsList;
		}

		
		


}
