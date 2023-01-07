(************************************************************
 * Result by: IMITATOR 3.4-beta "Cheese Durian" (build ?????/?????)
 * Model    : '/imitator/fff/pacemaker_JPMAM12.imi'
 * Generated: Fri Jan 6, 2023 13:25:36
 * Command  : /imitator/bin/imitator /imitator/fff/pacemaker_JPMAM12.imi /imitator/fff/pacemaker_JPMAM12.imiprop -comparison equality -merge none
 ************************************************************)


------------------------------------------------------------
Number of IPTAs                         : 7
Number of clocks                        : 9
Has invariants?                         : true
Has clocks with rate <>1?               : false
Has complex updates?                    : false
L/U subclass                            : not L/U
Bounded parameters?                     : false
Has silent actions?                     : false
Is strongly deterministic?              : true
Number of parameters                    : 2
Number of discrete variables            : 0
Number of actions                       : 13
Total number of locations               : 19
Average locations per IPTA              : 2.7
Total number of transitions             : 42
Average transitions per IPTA            : 6.0
------------------------------------------------------------

BEGIN RESULT

(************************************************************)
 Run #1

 Valuation:
  TAVI = 1
& TLRI = 201

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& 400 > TLRI
& TLRI >= 200 + TAVI

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"TAVI": "1",
			"TLRI": "201"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-999/2"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "201/2",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "201/2",
					"t_LRI": "201/2",
					"t_PVARP": "0",
					"t_VRP": "201/2",
					"t_5a": "201/2",
					"clk": "201/2",
					"x": "0",
					"x_urgent": "201/2",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "201/2",
					"t_PVARP": "0",
					"t_VRP": "201/2",
					"t_5a": "201/2",
					"clk": "201/2",
					"x": "0",
					"x_urgent": "201/2",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "201/2",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "201/2",
					"clk": "201/2",
					"x": "0",
					"x_urgent": "201/2",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "201/2",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "301/2",
					"global_time": "-349"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "401/2",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "150",
					"t_LRI": "150",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "150",
					"x_urgent": "501/2",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "200",
					"t_VRP": "200",
					"t_5a": "200",
					"clk": "200",
					"x": "0",
					"x_urgent": "601/2",
					"global_time": "-199"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "201",
					"t_VRP": "201",
					"t_5a": "201",
					"clk": "201",
					"x": "1",
					"x_urgent": "603/2",
					"global_time": "-198"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "199",
				"action": "VP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": " clk >= 400",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "200",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "0",
					"x": "200",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "FER",
				"transitions": [
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": " t_5a > TLRI AND x_urgent = 0",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "200",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "200",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #2

 Valuation:
  TAVI = 1
& TLRI = 150

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& TLRI >= 150
& TLRI >= 100 + TAVI
& 400 > TLRI

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"TAVI": "1",
			"TLRI": "150"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-548"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "149",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "149",
					"t_VRP": "149",
					"t_5a": "149",
					"clk": "149",
					"x": "0",
					"x_urgent": "149",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "149",
					"t_VRP": "0",
					"t_5a": "149",
					"clk": "149",
					"x": "0",
					"x_urgent": "149",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "149",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "199",
					"global_time": "-349"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "249",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "49",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "149",
					"t_LRI": "149",
					"t_PVARP": "0",
					"t_VRP": "149",
					"t_5a": "149",
					"clk": "149",
					"x": "0",
					"x_urgent": "298",
					"global_time": "-250"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "149",
					"t_PVARP": "0",
					"t_VRP": "149",
					"t_5a": "149",
					"clk": "149",
					"x": "0",
					"x_urgent": "298",
					"global_time": "-250"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "150",
					"t_PVARP": "1",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "299",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "150",
					"t_PVARP": "1",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "299",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "250",
				"action": "VP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": " clk >= 400",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "251",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "0",
					"x": "251",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "FER",
				"transitions": [
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": " t_5a > TLRI AND x_urgent = 0",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "251",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "251",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #3

 Valuation:
  TAVI = 1
& TLRI = 101

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& TLRI >= 100 + TAVI
& 400 > TLRI
& 50 >= TAVI

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"TAVI": "1",
			"TLRI": "101"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-499"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "100",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "100",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "100",
					"t_VRP": "0",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "100",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "100",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "150",
					"global_time": "-349"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "200",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "0",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "200",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "100",
					"t_PVARP": "0",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "200",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "1",
					"t_LRI": "101",
					"t_PVARP": "1",
					"t_VRP": "101",
					"t_5a": "101",
					"clk": "101",
					"x": "1",
					"x_urgent": "201",
					"global_time": "-298"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "49",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "50",
					"t_LRI": "150",
					"t_PVARP": "50",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "50",
					"x_urgent": "250",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "250",
				"action": "VP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": " clk >= 400",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "300",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "0",
					"x": "300",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "FER",
				"transitions": [
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": " t_5a > TLRI AND x_urgent = 0",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "300",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "300",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #4

 Valuation:
  TAVI = 1
& TLRI = 201

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& 400 > TLRI
& TLRI >= 200 + TAVI

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"TAVI": "1",
			"TLRI": "201"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-799"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "200",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "200",
					"t_VRP": "200",
					"t_5a": "200",
					"clk": "200",
					"x": "0",
					"x_urgent": "200",
					"global_time": "-599"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "201",
					"t_VRP": "201",
					"t_5a": "201",
					"clk": "201",
					"x": "1",
					"x_urgent": "201",
					"global_time": "-598"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "199",
				"action": "VP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": " clk >= 400",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "200",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "200",
					"x_urgent": "400",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "250",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "250",
					"x_urgent": "450",
					"global_time": "-349"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "300",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "300",
					"x_urgent": "500",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "350",
					"t_LRI": "150",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "350",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "400",
					"t_LRI": "200",
					"t_PVARP": "0",
					"t_VRP": "200",
					"t_5a": "200",
					"clk": "200",
					"x": "0",
					"x_urgent": "600",
					"global_time": "-199"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "0",
					"t_LRI": "200",
					"t_PVARP": "0",
					"t_VRP": "200",
					"t_5a": "200",
					"clk": "200",
					"x": "0",
					"x_urgent": "600",
					"global_time": "-199"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "1",
					"t_LRI": "201",
					"t_PVARP": "1",
					"t_VRP": "201",
					"t_5a": "201",
					"clk": "201",
					"x": "1",
					"x_urgent": "601",
					"global_time": "-198"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "199",
				"action": "VP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": " clk >= 400",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "200",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "0",
					"x": "200",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "FER",
				"transitions": [
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": " t_5a > TLRI AND x_urgent = 0",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "201",
					"t_AVI": "200",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "200",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #5

 Valuation:
  TAVI = 1
& TLRI = 150

 Other valuations with equivalent (discrete) run:
 TLRI >= 150
& TLRI >= 100 + TAVI
& TAVI + 150 >= TLRI
& TLRI > 2*TAVI

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"TAVI": "1",
			"TLRI": "150"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-298"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "75",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "75",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "75",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-223"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "75",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-223"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-223"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-223"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "125",
					"global_time": "-173"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "175",
					"global_time": "-123"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "49",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "149",
					"t_VRP": "149",
					"t_5a": "149",
					"clk": "149",
					"x": "0",
					"x_urgent": "224",
					"global_time": "-74"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "225",
					"global_time": "-73"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "225",
					"global_time": "-73"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "150",
					"t_VRP": "0",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "225",
					"global_time": "-73"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "74",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "75",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "224",
					"clk": "0",
					"x": "75",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "FER",
				"transitions": [
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": " t_5a > TLRI AND x_urgent = 0",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "75",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "75",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #6

 Valuation:
  TAVI = 1
& TLRI = 101

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& 150 >= TLRI
& TLRI >= 100 + TAVI

 Run nature: valid run

 Run:
{
	"run": {
		"nature": "concrete",
		"valuation": {
			"TAVI": "1",
			"TLRI": "101"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-399/2"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "101/2",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "101/2",
					"t_LRI": "101/2",
					"t_PVARP": "0",
					"t_VRP": "101/2",
					"t_5a": "101/2",
					"clk": "101/2",
					"x": "0",
					"x_urgent": "101/2",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "101/2",
					"t_PVARP": "0",
					"t_VRP": "101/2",
					"t_5a": "101/2",
					"clk": "101/2",
					"x": "0",
					"x_urgent": "101/2",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "101/2",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "101/2",
					"clk": "101/2",
					"x": "0",
					"x_urgent": "101/2",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "101/2",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "201/2",
					"global_time": "-99"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "301/2",
					"global_time": "-49"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "301/2",
					"global_time": "-49"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "101",
					"t_VRP": "101",
					"t_5a": "101",
					"clk": "101",
					"x": "1",
					"x_urgent": "303/2",
					"global_time": "-48"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "49",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "50",
					"x_urgent": "401/2",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "150",
					"t_VRP": "0",
					"t_5a": "150",
					"clk": "150",
					"x": "50",
					"x_urgent": "401/2",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "50",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "150",
					"clk": "0",
					"x": "50",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "FER",
				"transitions": [
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": " t_5a > TLRI AND x_urgent = 0",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "101",
					"t_AVI": "50",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "50",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #7

 Valuation:
  TAVI = 0
& TLRI = 150

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& TAVI + 200 > TLRI
& TLRI >= 150 + TAVI
& TLRI >= 2*TAVI

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"TAVI": "0",
			"TLRI": "150"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-225"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "75",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "75",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "75",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-150"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "75",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-150"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-150"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-150"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "125",
					"global_time": "-100"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "175",
					"global_time": "-50"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "150",
					"t_LRI": "150",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "150",
					"x_urgent": "225",
					"global_time": "0"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "225",
					"global_time": "0"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "225",
					"global_time": "0"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "VP"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "151",
					"t_VRP": "151",
					"t_5a": "151",
					"clk": "151",
					"x": "1",
					"x_urgent": "226",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "FER"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "150",
					"t_AVI": "2",
					"t_LRI": "2",
					"t_PVARP": "152",
					"t_VRP": "152",
					"t_5a": "152",
					"clk": "152",
					"x": "2",
					"x_urgent": "227",
					"global_time": "2"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #8

 Valuation:
  TAVI = 0
& TLRI = 400

 Other valuations with equivalent (discrete) run:
 TAVI + 1000 > TLRI
& TAVI >= 0
& TLRI >= 400
& 300 > TAVI

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"TAVI": "0",
			"TLRI": "400"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-799"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "400",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "400",
					"t_VRP": "400",
					"t_5a": "400",
					"clk": "400",
					"x": "0",
					"x_urgent": "400",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "400",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "400",
					"x": "0",
					"x_urgent": "400",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "400",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "450",
					"global_time": "-349"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "500",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "150",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "250",
				"action": "VP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": " clk >= 400",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "250",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "0",
					"x": "250",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "FER"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "251",
					"t_LRI": "1",
					"t_PVARP": "1",
					"t_VRP": "1",
					"t_5a": "401",
					"clk": "1",
					"x": "251",
					"x_urgent": "1",
					"global_time": "2"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #9

 Valuation:
  TAVI = 0
& TLRI = 400

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& TAVI + 1000 > TLRI
& TLRI >= 400
& 50 >= TAVI

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"TAVI": "0",
			"TLRI": "400"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-799"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "400",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "400",
					"t_VRP": "400",
					"t_5a": "400",
					"clk": "400",
					"x": "0",
					"x_urgent": "400",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "400",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "400",
					"x": "0",
					"x_urgent": "400",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "400",
					"global_time": "-399"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "450",
					"global_time": "-349"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "500",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "150",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "0",
					"t_LRI": "150",
					"t_PVARP": "0",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "0",
					"x_urgent": "550",
					"global_time": "-249"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "250",
				"action": "VP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": " clk >= 400",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "250",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "400",
					"clk": "0",
					"x": "250",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "FER"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "400",
					"t_AVI": "251",
					"t_LRI": "1",
					"t_PVARP": "1",
					"t_VRP": "1",
					"t_5a": "401",
					"clk": "1",
					"x": "251",
					"x_urgent": "1",
					"global_time": "2"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #10

 Valuation:
  TAVI = 0
& TLRI = 0

 Other valuations with equivalent (discrete) run:
 TAVI >= 0
& TAVI + 200 > TLRI
& TLRI >= 2*TAVI

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"TAVI": "0",
			"TLRI": "0"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "VP"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "1",
					"t_VRP": "1",
					"t_5a": "1",
					"clk": "1",
					"x": "1",
					"x_urgent": "1",
					"global_time": "2"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "PVARPac"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "2",
					"t_LRI": "2",
					"t_PVARP": "2",
					"t_VRP": "2",
					"t_5a": "2",
					"clk": "2",
					"x": "2",
					"x_urgent": "2",
					"global_time": "3"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "PVARPbacktoIdle"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "3",
					"t_LRI": "3",
					"t_PVARP": "3",
					"t_VRP": "3",
					"t_5a": "3",
					"clk": "3",
					"x": "3",
					"x_urgent": "3",
					"global_time": "4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "VRPac"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "4",
					"t_LRI": "4",
					"t_PVARP": "4",
					"t_VRP": "4",
					"t_5a": "4",
					"clk": "4",
					"x": "4",
					"x_urgent": "4",
					"global_time": "5"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "Aget"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "5",
					"t_LRI": "5",
					"t_PVARP": "5",
					"t_VRP": "5",
					"t_5a": "5",
					"clk": "5",
					"x": "5",
					"x_urgent": "5",
					"global_time": "6"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "AS"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "6",
					"t_LRI": "6",
					"t_PVARP": "6",
					"t_VRP": "6",
					"t_5a": "6",
					"clk": "6",
					"x": "6",
					"x_urgent": "6",
					"global_time": "7"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "AVIac"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "7",
					"t_LRI": "7",
					"t_PVARP": "7",
					"t_VRP": "7",
					"t_5a": "7",
					"clk": "7",
					"x": "7",
					"x_urgent": "7",
					"global_time": "8"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "VP"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "8",
					"t_LRI": "8",
					"t_PVARP": "8",
					"t_VRP": "8",
					"t_5a": "8",
					"clk": "8",
					"x": "8",
					"x_urgent": "8",
					"global_time": "9"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "FER"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "0",
					"TLRI": "0",
					"t_AVI": "9",
					"t_LRI": "9",
					"t_PVARP": "9",
					"t_VRP": "9",
					"t_5a": "9",
					"clk": "9",
					"x": "9",
					"x_urgent": "9",
					"global_time": "10"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #11

 Valuation:
  TAVI = 100
& TLRI = 200

 Other valuations with equivalent (discrete) run:
 150 >= TAVI
& TAVI >= 100
& 2*TAVI = TLRI

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"TAVI": "100",
			"TLRI": "200"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-299"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "100",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "0",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "100",
					"global_time": "-199"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "0",
					"t_LRI": "100",
					"t_PVARP": "0",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "100",
					"global_time": "-199"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "0",
					"t_LRI": "100",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "100",
					"global_time": "-199"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "100",
					"global_time": "-199"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "150",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "200",
					"global_time": "-99"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "0",
					"x_urgent": "200",
					"global_time": "-99"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "50",
					"x_urgent": "250",
					"global_time": "-49"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "200",
					"t_VRP": "200",
					"t_5a": "200",
					"clk": "200",
					"x": "100",
					"x_urgent": "300",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "200",
					"t_VRP": "0",
					"t_5a": "200",
					"clk": "200",
					"x": "100",
					"x_urgent": "300",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "100",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "200",
					"clk": "0",
					"x": "100",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "FER"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "100",
					"TLRI": "200",
					"t_AVI": "101",
					"t_LRI": "1",
					"t_PVARP": "1",
					"t_VRP": "1",
					"t_5a": "201",
					"clk": "1",
					"x": "101",
					"x_urgent": "1",
					"global_time": "2"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #12

 Valuation:
  TAVI = 1
& TLRI = 150

 Other valuations with equivalent (discrete) run:
 TLRI >= 150
& TLRI >= 100 + TAVI
& TAVI + 150 >= TLRI
& TLRI > 2*TAVI

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"TAVI": "1",
			"TLRI": "150"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-224"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "75",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "75",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "75",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "75",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "75",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "75",
					"clk": "75",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "75",
					"global_time": "-149"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "125",
					"global_time": "-99"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "175",
					"global_time": "-49"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "49",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "149",
					"t_VRP": "149",
					"t_5a": "149",
					"clk": "149",
					"x": "0",
					"x_urgent": "224",
					"global_time": "0"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "1",
				"action": "VRPac",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": " t_VRP >= 150",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "225",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AVIac",
				"transitions": [
					{
					"transition": {
						"PTA": "AVI",
						"guard": " 400 > clk AND t_AVI >= TAVI",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "150",
					"t_VRP": "150",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "225",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "150",
					"t_VRP": "0",
					"t_5a": "150",
					"clk": "150",
					"x": "1",
					"x_urgent": "225",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"x_urgent": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "150",
					"clk": "0",
					"x": "1",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "0",
				"action": "FER"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "150",
					"t_AVI": "1",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "150",
					"clk": "0",
					"x": "1",
					"x_urgent": "0",
					"global_time": "1"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)


(************************************************************)
 Run #13

 Valuation:
  TAVI = 1
& TLRI = 301/2

 Other valuations with equivalent (discrete) run:
 TLRI > 150
& TAVI + 150 >= TLRI
& TLRI >= 100 + TAVI

 Run nature: impossible run

 Run:
{
	"run": {
		"nature": "negative",
		"valuation": {
			"TAVI": "1",
			"TLRI": "301/2"
			},
		"steps": [
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "0",
					"global_time": "-224"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			},
			{
			"transition": {
				"nature": "concrete",
				"duration": "301/4",
				"action": "Aget",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": " x > 0",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "inter", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "301/4",
					"t_LRI": "301/4",
					"t_PVARP": "0",
					"t_VRP": "301/4",
					"t_5a": "301/4",
					"clk": "301/4",
					"x": "0",
					"x_urgent": "301/4",
					"global_time": "-595/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "AS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "0",
					"t_LRI": "301/4",
					"t_PVARP": "0",
					"t_VRP": "301/4",
					"t_5a": "301/4",
					"clk": "301/4",
					"x": "0",
					"x_urgent": "301/4",
					"global_time": "-595/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "Vget",
				"transitions": [
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "ASed", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_1st"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "0",
					"t_LRI": "301/4",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "301/4",
					"clk": "301/4",
					"x": "0",
					"x_urgent": "301/4",
					"global_time": "-595/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "0",
				"action": "VS",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": "True",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "URI",
						"guard": "True",
						"updates": {
							"clk": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "PVARP",
						"guard": "True",
						"updates": {
							"t_PVARP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
							"t_VRP": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "monitor5a",
						"guard": "True",
						"updates": {
							"t_5a": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "0",
					"t_VRP": "0",
					"t_5a": "0",
					"clk": "0",
					"x": "0",
					"x_urgent": "301/4",
					"global_time": "-595/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPac",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 50",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVARP", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "50",
					"t_LRI": "50",
					"t_PVARP": "50",
					"t_VRP": "50",
					"t_5a": "50",
					"clk": "50",
					"x": "50",
					"x_urgent": "501/4",
					"global_time": "-395/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "50",
				"action": "PVARPbacktoIdle",
				"transitions": [
					{
					"transition": {
						"PTA": "PVARP",
						"guard": " t_PVARP >= 100",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "100",
					"t_LRI": "100",
					"t_PVARP": "100",
					"t_VRP": "100",
					"t_5a": "100",
					"clk": "100",
					"x": "100",
					"x_urgent": "701/4",
					"global_time": "-195/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}, 
			{
			"transition": {
				"nature": "concrete",
				"duration": "99/2",
				"action": "AP",
				"transitions": [
					{
					"transition": {
						"PTA": "LRI",
						"guard": " TAVI + t_LRI >= TLRI",
						"updates": {
							"t_LRI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "AVI",
						"guard": "True",
						"updates": {
							"t_AVI": "0"
						}
					}
					}, 
					{
					"transition": {
						"PTA": "VRP",
						"guard": "True",
						"updates": {
						}
					}
					}, 
					{
					"transition": {
						"PTA": "RHM",
						"guard": "True",
						"updates": {
							"x": "0"
						}
					}
					}
				]
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "AVI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "0",
					"t_LRI": "0",
					"t_PVARP": "299/2",
					"t_VRP": "299/2",
					"t_5a": "299/2",
					"clk": "299/2",
					"x": "0",
					"x_urgent": "899/4",
					"global_time": "3/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "impossible",
				"duration": "1",
				"action": "AVIac"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "1",
					"t_LRI": "1",
					"t_PVARP": "301/2",
					"t_VRP": "301/2",
					"t_5a": "301/2",
					"clk": "301/2",
					"x": "1",
					"x_urgent": "903/4",
					"global_time": "7/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "VRPac"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "Idle", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "2",
					"t_LRI": "2",
					"t_PVARP": "303/2",
					"t_VRP": "303/2",
					"t_5a": "303/2",
					"clk": "303/2",
					"x": "2",
					"x_urgent": "907/4",
					"global_time": "11/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "Vget"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "WaitURI", 
					"URI": "URI", 
					"PVARP": "Idle", 
					"VRP": "inter", 
					"RHM": "AReady", 
					"monitor5a": "wait_2nd"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "3",
					"t_LRI": "3",
					"t_PVARP": "305/2",
					"t_VRP": "305/2",
					"t_5a": "305/2",
					"clk": "305/2",
					"x": "3",
					"x_urgent": "911/4",
					"global_time": "15/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "VS"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "two_a"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "4",
					"t_LRI": "4",
					"t_PVARP": "307/2",
					"t_VRP": "307/2",
					"t_5a": "307/2",
					"clk": "307/2",
					"x": "4",
					"x_urgent": "915/4",
					"global_time": "19/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}

			{
			"transition": {
				"nature": "arbitrary",
				"duration": "1",
				"action": "FER"
			}
			},
			{
			"state": {
				"location": {
					"LRI": "LRI", 
					"AVI": "Idle", 
					"URI": "URI", 
					"PVARP": "PVAB", 
					"VRP": "VRP", 
					"RHM": "AReady", 
					"monitor5a": "monitor5a_BAD"
				},
				"discrete_variables": {
				},
				"continuous_variables": {
					"TAVI": "1",
					"TLRI": "301/2",
					"t_AVI": "5",
					"t_LRI": "5",
					"t_PVARP": "309/2",
					"t_VRP": "309/2",
					"t_5a": "309/2",
					"clk": "309/2",
					"x": "5",
					"x_urgent": "919/4",
					"global_time": "23/4"
				},
				"flows": {
					"t_AVI": "1", 
					"t_LRI": "1", 
					"t_PVARP": "1", 
					"t_VRP": "1", 
					"t_5a": "1", 
					"clk": "1", 
					"x": "1", 
					"x_urgent": "1", 
					"global_time": "1"
				}
			}
			}
		]
	}
}
(************************************************************)

END RESULT

------------------------------------------------------------
Number of states                        : 1607
Number of transitions                   : 1753
Number of computed states               : 1754
Total computation time                  : 7.382 seconds
States/second in state space            : 217.6 (1607/7.382 seconds)
Computed states/second                  : 237.5 (1754/7.382 seconds)
Estimated memory                        : 90.643 MiB (i.e., 11880808 words of size 8)
------------------------------------------------------------

------------------------------------------------------------
 Statistics: Algorithm counters
------------------------------------------------------------
main algorithm + parsing                : 7.387 seconds
main algorithm                          : 7.382 seconds
------------------------------------------------------------
 Statistics: Parsing counters
------------------------------------------------------------
model parsing and converting            : 0.003 second
------------------------------------------------------------
 Statistics: State computation counters
------------------------------------------------------------
number of constraints comparisons       : 42668
number of state comparisons             : 42668
number of new states <= old             : 0
number of new states >= old             : 0
StateSpace.merging attempts             : 0
StateSpace.merges                       : 0
StateSpace.Merge time                   : 0.000 second
StateSpace.Merge (reconstruct state space): 0.000 second
------------------------------------------------------------
 Statistics: Graphics-related counters
------------------------------------------------------------
state space drawing                     : 0.000 second
------------------------------------------------------------
 Statistics: Global counter
------------------------------------------------------------
total                                   : 7.477 seconds
------------------------------------------------------------