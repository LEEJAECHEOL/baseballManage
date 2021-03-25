package com.cos.baseball.query;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PositionQuery {
	
	private final EntityManager em;
	
	public Query positionPivot() {
		StringBuffer sb = new StringBuffer();
		sb.append("select position, ");
		sb.append("GROUP_CONCAT(if(tid='1', name, NULL)) AS 'dusan', ");
		sb.append("GROUP_CONCAT(if(tid='2', name, NULL)) AS 'hanhwa', ");
		sb.append("GROUP_CONCAT(if(tid='3', name, NULL)) AS 'lotte' ");
		sb.append(" FROM ( ");
		sb.append("SELECT p.name as name, p.position as position, t.name as tname, t.id as tid ");
		sb.append("FROM player p inner join team t on p.teamid = t.id ");
		sb.append(") test group by position;");
		Query query = em.createNativeQuery(sb.toString());	
		return query;
	}
	
}
