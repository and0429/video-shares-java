package com.coffee.share.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author and04
 *
 */
@XmlRootElement(name = "systems")
public class ClientSystemList {

	private List<ClientSystem> systems = new ArrayList<>();
	
	@XmlElement(name = "system")
	public List<ClientSystem> getSystems() {
		return systems;
	}

	public void setSystems(List<ClientSystem> systems) {
		this.systems = systems;
	}
}
